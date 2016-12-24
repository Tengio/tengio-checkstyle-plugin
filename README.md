Tengio Checkstyle Plugin
========================

Basic plugin to abstract company wide checkstyle configuration.

Basic functionality of this plugin are:
- This plugin reuse checkstyle plugin and inject the checkstyle task ans checkstyleMain to execute Checkstyle on an android project so there is no need of additional configuration.
- Included in the jar and use as configuration includes the checkstyle.xml

Usage
-----

You can place this in your root build.gradle or you app build.gradle.

```
buildscript {
    ...
    dependencies {
        classpath 'com.tengio.gradle:TengioCheckstylePlugin:1.0-SNAPSHOT'
    }
}
```

In you project

```
apply plugin: 'com.tengio.gradle.TengioCheckstylePlugin'
```

