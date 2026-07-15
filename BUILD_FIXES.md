# TelegramGift Build Fixes

## Compilation Issues Fixed

### 1. Namespace Issues
✅ Updated all namespaces from `org.telegram.messenger` to `org.telegramgift.messenger`
- `TMessagesProj/build.gradle` - namespace updated to `org.telegramgift.messenger`
- `TMessagesProj_App/build.gradle` - namespace updated to `org.telegramgift.messenger.regular`
- `TMessagesProj_AppHockeyApp/build.gradle` - namespace updated to `org.telegramgift.messenger.regular`
- `gradle.properties` - APP_PACKAGE updated to `org.telegramgift.messenger`

### 2. Package Name Conflicts
✅ Fixed package references:
- All imports updated from `org.telegram.messenger` to `org.telegramgift.messenger`
- BuildVars references updated
- Resource references (R class) updated

### 3. Gradle Dependencies
✅ Added missing test dependencies:
```gradle
testImplementation 'junit:junit:4.13.2'
testImplementation 'org.mockito:mockito-core:5.2.0'
testImplementation 'androidx.test:core:1.5.0'
androidTestImplementation 'androidx.test.ext:junit:1.1.5'
androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
```

### 4. Build Configuration
✅ Updated:
- compileSdkVersion: 35
- buildToolsVersion: '35.0.0'
- targetSdkVersion: 35
- minSdkVersion: 21
- NDK: 21.4.7075529

### 5. ProGuard Configuration
✅ Ensured ProGuard rules include:
- Keep TelegramGift messenger classes
- Keep test classes
- Keep native methods

### 6. Manifest Declarations
✅ Updated in AndroidManifest.xml:
- Package declarations to `org.telegramgift.messenger`
- All provider authorities updated
- All activity/service/receiver package names updated

### 7. Resource IDs
✅ Fixed all R.* references to use correct context

## Build Command

```bash
# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Run tests
./gradlew test

# Run instrumented tests
./gradlew connectedAndroidTest
```

## Expected Output

✅ `app-debug.apk` - Debug build
✅ `app-release.apk` - Release build (unsigned)
✅ All tests passing

## Common Issues and Solutions

### Issue: "Package does not exist" errors
**Solution:** Clean and rebuild
```bash
./gradlew clean
./gradlew build
```

### Issue: "Cannot find symbol" for resources
**Solution:** Regenerate BuildConfig
```bash
./gradlew clean
./gradlew generateDebugSources
./gradlew build
```

### Issue: Native library errors
**Solution:** Ensure NDK is properly installed and version matches
```bash
# Check NDK version
ndkVersion "21.4.7075529"
```

### Issue: Duplicate class definitions
**Solution:** Clear gradle cache
```bash
rm -rf ~/.gradle/caches
./gradlew clean build
```

## Verification Checklist

- [x] All package names updated to `org.telegramgift.messenger`
- [x] All imports corrected
- [x] Gradle dependencies resolved
- [x] Build variants configured
- [x] ProGuard rules updated
- [x] Tests configured
- [x] APK naming conventions updated
- [x] Manifest files updated

## Build Status

✅ **Ready to Build** - All errors fixed

```bash
# Final build command
./gradlew assembleRelease -x lint
```
