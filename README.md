# Flappy Bird Android Game

A classic Flappy Bird clone built for Android devices. Navigate the bird through pipes by tapping to flap and avoid obstacles!

## 🎮 Features

- **Smooth Gameplay**: 60 FPS game loop with physics-based bird movement
- **Random Pipe Generation**: Procedurally generated pipe obstacles with gaps
- **Score System**: Track your high score as you pass through pipes
- **Collision Detection**: Precise hit detection for pipes and boundaries
- **Game Over & Restart**: Tap to restart after game over
- **Custom Bird Design**: Colorful bird with detailed graphics

## 🚀 How to Play

1. Tap the screen to make the bird flap upward
2. Navigate through the green pipe gaps
3. Avoid hitting pipes or the ground/sky
4. Score points for each pipe you pass through
5. Try to beat your high score!

## 🛠️ Technical Details

- **Language**: Java
- **Platform**: Android (API 21+)
- **Graphics**: Canvas-based 2D rendering
- **Architecture**: SurfaceView with game thread
- **Build System**: Gradle

### Key Components

- `MainActivity.java`: App entry point and lifecycle management
- `GameView.java`: Core game logic, rendering, and input handling
- Custom classes for Bird and Pipe objects
- Physics simulation with gravity and jump mechanics

## 📱 Installation & Setup

### Prerequisites
- Android Studio (latest version recommended)
- Android SDK API level 21 or higher
- JDK 17 or higher

### Building the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/jvenuto80/flippybird.git
   cd flippybird
   ```

2. Open in Android Studio:
   - Launch Android Studio
   - Select "Open an existing Android Studio project"
   - Navigate to the cloned directory and select it

3. Build and run:
   - Connect an Android device or start an emulator
   - Click the "Run" button (green play icon) in Android Studio
   - Select your target device and enjoy!

## 🎨 Game Mechanics

- **Bird Physics**: Gravity constantly pulls the bird down
- **Flapping**: Tap screen for upward impulse (-12 velocity units)
- **Pipe Movement**: Pipes scroll left at 5 pixels per frame
- **Gap Size**: 350 pixels between top and bottom pipes
- **Pipe Spacing**: 500 pixels between pipe pairs
- **Scoring**: +1 point per pipe passed

## 🏗️ Project Structure

```
app/
├── src/main/
│   ├── AndroidManifest.xml
│   ├── java/com/example/flappybird/
│   │   ├── MainActivity.java
│   │   └── GameView.java
│   └── res/
│       ├── layout/
│       │   └── activity_main.xml
│       └── values/
│           ├── strings.xml
│           └── styles.xml
├── build.gradle
└── proguard-rules.pro
```

## 🤝 Contributing

Feel free to fork this project and submit pull requests! Ideas for improvements:
- Add sound effects and background music
- Implement high score persistence
- Add different bird skins/themes
- Include power-ups or special abilities
- Add multiplayer features

## 📄 License

This project is open source and available under the MIT License.

## 🙏 Acknowledgments

- Inspired by the original Flappy Bird game
- Built with Android Studio and Java
- Thanks to the Android developer community

---

**Have fun playing!** 🐦🎮