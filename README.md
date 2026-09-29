# Aile ✈️

**Aile** is an open-source, offline-first flight tracking application built exclusively for Android. Inspired by the premium experience of top-tier flight trackers, Aile aims to bring a beautifully designed, "Material 3 Expressive" flight tracker to the Android ecosystem.

## 🎯 Goals
- **Android Exclusive**: Leverage the best of Android UI/UX with Material 3.
- **Offline First**: All data is cached locally. View your flights without an internet connection.
- **Incremental Open Source**: Built in public, learning Kotlin and Modern Android Development (MAD) best practices along the way.
- **Cost Efficient**: Uses free-tier APIs (AirLabs/OpenSky) to keep running costs at zero.

## 🛠️ Tech Stack
- **Language**: Kotlin
- **UI**: Jetpack Compose (Material 3 Expressive)
- **Architecture**: MVVM with Clean Architecture (Data, Domain, UI layers)
- **DI**: Hilt
- **Async**: Coroutines & Flow
- **Network**: Retrofit & Moshi
- **Local Data**: Room Database
- **Build**: Gradle KTS with Version Catalogs

## 🚀 Getting Started

### Prerequisites
- Android Studio Koala or later (for latest Compose and Gradle features).
- JDK 17+.

### Setup
1. **Clone the repository**:
   ```bash
   git clone https://github.com/aile-app/android-app.git
   ```
2. **Open in Android Studio**.
3. **Initialize Gradle wrapper** (required for fresh checkout):
   ```bash
   ./gradlew wrapper
   ```
4. **API Keys**:
   - The app uses [AirLabs](https://airlabs.co/) for flight data.
   - Sign up at https://airlabs.co/ to get a free API key
   - For development, a demo key is used (limited functionality)

## 🗺️ Roadmap

### Phase 1: Foundation ✅
- [x] Project Setup (Compose, Hilt, Gradle KTS)
- [x] Material 3 Expressive Theme configuration
- [x] Architecture scaffolding

### Phase 2: Core Features 🚧
- [x] Room Database implementation (FlightEntity, AirportEntity, AirlineEntity + DAOs)
- [x] Flight Search & Input UI (FlightSearchScreen + ViewModel)
- [x] AirLabs API Integration (Flight status search via Retrofit)
- [ ] Offline Caching logic (merge API results into Room)
- [ ] Proper API key configuration (local.properties / BuildConfig)

### Phase 3: Polish ✨
- [ ] Advanced Material 3 Animations
- [ ] Live Activities / Widgets (future)
- [ ] Tablet/Foldable support

## 📄 License
MIT License
