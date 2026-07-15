-keep class org.telegramgift.messenger.** { *; }
-keep interface org.telegramgift.messenger.** { *; }
-keepclasseswithmembernames class org.telegramgift.messenger.** { native <methods>; }

# Keep test classes
-keep class org.telegramgift.messenger.test.** { *; }

# Firebase
-keep class com.google.firebase.** { *; }
-keep class com.google.android.gms.** { *; }

# WebRTC
-keep class org.webrtc.** { *; }
-keepclasseswithmembernames class org.webrtc.** { native <methods>; }

# Telegram protocol
-keep class org.telegram.tgnet.** { *; }
-keep class org.telegram.ui.** { *; }

# ExoPlayer
-keep class com.google.android.exoplayer2.** { *; }

# Stripe
-keep class com.stripe.** { *; }

# Microsoft App Center
-keep class com.microsoft.appcenter.** { *; }

# Keep enums
-keepclassmembers enum org.telegramgift.messenger.** { public static **[] values(); public static ** valueOf(java.lang.String); }

# Generic exceptions
-keep public class * extends java.lang.Exception
-keep public class * extends java.lang.Throwable

# Support library
-dontwarn androidx.**
-keep class androidx.** { *; }
-keep interface androidx.** { *; }

# Reflect annotation
-keepattributes Signature, RuntimeVisibleAnnotations, AnnotationDefault

# Remove logging
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
}
