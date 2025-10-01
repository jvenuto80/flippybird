package com.example.flappybird;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.ArrayList;
import java.util.Random;

public class GameView extends SurfaceView implements Runnable {

    private Thread gameThread;
    private boolean isPlaying;
    private SurfaceHolder holder;
    private Paint paint;
    private Random random;

    // Game objects
    private Bird bird;
    private ArrayList<Pipe> pipes;
    private int score;
    private boolean gameOver;

    // Screen dimensions
    private int screenWidth;
    private int screenHeight;

    // Game constants
    private static final int PIPE_WIDTH = 100;
    private static final int PIPE_GAP = 350;
    private static final int BIRD_SIZE = 50;
    private static final float GRAVITY = 0.5f;
    private static final float JUMP_FORCE = -12f;
    private static final int PIPE_SPEED = 5;
    private static final int PIPE_SPACING = 500;

    public GameView(Context context) {
        super(context);
        holder = getHolder();
        paint = new Paint();
        random = new Random();

        // Initialize game objects
        bird = new Bird();
        pipes = new ArrayList<>();
        score = 0;
        gameOver = false;

        // Pipes will be initialized in onSizeChanged
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenWidth = w;
        screenHeight = h;
        bird.x = w / 4;
        bird.y = h / 2;

        // Initialize pipes now that screenHeight is known
        pipes.clear();
        for (int i = 0; i < 3; i++) {
            pipes.add(new Pipe(800 + i * PIPE_SPACING));
        }
    }

    @Override
    public void run() {
        while (isPlaying) {
            update();
            draw();
            try {
                Thread.sleep(16); // ~60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        if (gameOver) return;

        // Update bird
        bird.velocity += GRAVITY;
        bird.y += bird.velocity;

        // Update pipes
        for (Pipe pipe : pipes) {
            pipe.x -= PIPE_SPEED;

            // Check collision
            if (bird.getRect().intersect(pipe.getTopRect()) ||
                bird.getRect().intersect(pipe.getBottomRect()) ||
                bird.y < 0 || bird.y > screenHeight) {
                gameOver = true;
            }

            // Score
            if (!pipe.passed && pipe.x + PIPE_WIDTH < bird.x) {
                pipe.passed = true;
                score++;
            }
        }

        // Remove off-screen pipes and add new ones
        if (!pipes.isEmpty() && pipes.get(0).x + PIPE_WIDTH < 0) {
            pipes.remove(0);
            pipes.add(new Pipe(pipes.get(pipes.size() - 1).x + PIPE_SPACING));
        }
    }

    private void draw() {
        if (holder.getSurface().isValid()) {
            Canvas canvas = holder.lockCanvas();
            canvas.drawColor(Color.CYAN); // Sky background

            // Draw pipes
            paint.setColor(Color.GREEN);
            for (Pipe pipe : pipes) {
                canvas.drawRect(pipe.getTopRect(), paint);
                canvas.drawRect(pipe.getBottomRect(), paint);
            }

            // Draw bird
            paint.setColor(Color.YELLOW);
            // Body
            canvas.drawOval(bird.x - BIRD_SIZE/2, bird.y - BIRD_SIZE/3, bird.x + BIRD_SIZE/2, bird.y + BIRD_SIZE/3, paint);
            // Head
            canvas.drawOval(bird.x - BIRD_SIZE/4, bird.y - BIRD_SIZE/2, bird.x + BIRD_SIZE/4, bird.y, paint);
            // Beak
            paint.setColor(Color.rgb(255, 165, 0));
            canvas.drawOval(bird.x + BIRD_SIZE/4 - 5, bird.y - 10, bird.x + BIRD_SIZE/4 + 10, bird.y + 5, paint);
            // Eye
            paint.setColor(Color.BLACK);
            canvas.drawCircle(bird.x, bird.y - BIRD_SIZE/4, 5, paint);
            // Wing
            paint.setColor(Color.rgb(200, 200, 0));
            canvas.drawOval(bird.x - BIRD_SIZE/3, bird.y - 5, bird.x + BIRD_SIZE/6, bird.y + 10, paint);

            // Draw score
            paint.setColor(Color.BLACK);
            paint.setTextSize(50);
            canvas.drawText("Score: " + score, 50, 100, paint);

            if (gameOver) {
                paint.setTextSize(80);
                canvas.drawText("Game Over", screenWidth / 2 - 200, screenHeight / 2, paint);
                paint.setTextSize(40);
                canvas.drawText("Tap to Restart", screenWidth / 2 - 150, screenHeight / 2 + 100, paint);
            }

            holder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (gameOver) {
                resetGame();
            } else {
                bird.velocity = JUMP_FORCE;
            }
        }
        return true;
    }

    private void resetGame() {
        bird.y = screenHeight / 2;
        bird.velocity = 0;
        pipes.clear();
        for (int i = 0; i < 3; i++) {
            pipes.add(new Pipe(800 + i * PIPE_SPACING));
        }
        score = 0;
        gameOver = false;
    }

    public void resume() {
        isPlaying = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void pause() {
        isPlaying = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Inner classes
    private class Bird {
        float x, y, velocity;

        Rect getRect() {
            return new Rect((int)(x - BIRD_SIZE/2), (int)(y - BIRD_SIZE/2),
                           (int)(x + BIRD_SIZE/2), (int)(y + BIRD_SIZE/2));
        }
    }

    private class Pipe {
        int x, topHeight;
        boolean passed;

        Pipe(int x) {
            this.x = x;
            this.topHeight = random.nextInt(screenHeight - PIPE_GAP - 400) + 200;
            passed = false;
        }

        Rect getTopRect() {
            return new Rect(x, 0, x + PIPE_WIDTH, topHeight);
        }

        Rect getBottomRect() {
            return new Rect(x, topHeight + PIPE_GAP, x + PIPE_WIDTH, screenHeight);
        }
    }
}