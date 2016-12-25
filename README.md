Tengio Checkstyle Plugin
========================

Basic plugin to abstract company wide checkstyle configuration.

Basic functionality of this plugin are:
- This plugin reuse checkstyle plugin and inject the checkstyle task ans checkstyleMain to execute Checkstyle on an android project so there is no need of additional configuration.
- Included in the jar and use as configuration includes the checkstyle.xml

Usage
-----

You can place this in your root build.gradle or you app build.gradle.

Build script snippet for use in all Gradle versions:

```
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.com.tengio.gradle:tengio-checkstyle-plugin:1.0"
  }
}

apply plugin: "com.tengio.gradle.tengio-checkstyle-plugin"
```

Build script snippet for new, incubating, plugin mechanism introduced in Gradle 2.1:

```
plugins {
  id "com.tengio.gradle.tengio-checkstyle-plugin" version "1.0"
}
```