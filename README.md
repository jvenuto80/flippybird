# Flappy Bird Android Game

A classic Flappy Bird clone built for Android devices with beautiful Studio Ghibli-inspired graphics. Navigate the bird through bamboo pipes by tapping to flap and avoid obstacles in this charming, procedurally generated world!

## 🎮 Features

- **Smooth Gameplay**: 60 FPS OpenGL ES rendering with physics-based bird movement
- **Studio Ghibli-Inspired Art**: Procedurally generated textures featuring cute birds, bamboo pipes, cherry blossom trees, fluffy clouds, rolling hills, and a warm sun
- **Random Pipe Generation**: Procedurally generated bamboo pipe obstacles with gaps
- **Score System**: Track your high score as you pass through pipes
- **Collision Detection**: Precise hit detection for pipes and boundaries
- **Game Over & Restart**: Tap to restart after game over
- **Mountainous Background**: Multiple layered hills for depth and atmosphere
- **Hardware Accelerated**: OpenGL ES 2.0 for smooth performance

## 🚀 How to Play

1. Tap the screen to make the bird flap upward
2. Navigate through the bamboo pipe gaps
3. Avoid hitting pipes or the ground/sky
4. Score points for each pipe you pass through
5. Try to beat your high score!

## 🛠️ Technical Details

- **Language**: Java
- **Platform**: Android (API 21+)
- **Graphics**: OpenGL ES 2.0 with custom shaders and textures
- **Architecture**: GLSurfaceView with renderer pattern
- **Textures**: Programmatically generated using Canvas API
- **Build System**: Gradle

### Key Components

- `MainActivity.java`: App entry point and lifecycle management
- `GameView.java`: GLSurfaceView with FlappyRenderer for game logic, OpenGL rendering, and input handling
- Custom texture generation methods for all game assets
- Physics simulation with gravity and jump mechanics
- OpenGL ES shaders for textured rendering

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

## 🎨 Art Style

This game features a unique Studio Ghibli-inspired art style with procedurally generated textures:

- **Bird**: Cute cartoon bird with soft colors, expressive eyes, and gentle wings
- **Pipes**: Bamboo-style pipes with green gradients and rim highlights
- **Background**: Layered hills, cherry blossom trees, fluffy clouds, and a warm sun
- **Color Palette**: Soft pastels with warm yellows, greens, and pinks

All textures are generated at runtime using Android's Canvas and Paint APIs, ensuring the game is self-contained with no external asset dependencies.

## 🤝 Contributing

Feel free to fork this project and submit pull requests! Ideas for improvements:
- Add sound effects and background music
- Implement different themes or skins
- Add power-ups or special abilities
- Include particle effects or animations
- Add multiplayer features
- Optimize for different screen sizes

## 📄 License

This project is open source and available under the MIT License.

## 🙏 Acknowledgments

- Inspired by the original Flappy Bird game
- Art style inspired by Studio Ghibli films
- Built with Android Studio, Java, and OpenGL ES
- Thanks to the Android developer community

---

**Have fun playing!** 🐦🎮