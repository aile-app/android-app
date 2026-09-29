#!/bin/sh

APP_HOME="$(dirname "$0")"
APP_NAME="Gradle"

# Find gradle wrapper jar
for jarfile in "$APP_HOME"/gradle/wrapper/gradle-wrapper.jar \
               "$APP_HOME"/gradle-wrapper.jar \
               "$APP_HOME"/lib/gradle-wrapper.jar; do
    if [ -f "$jarfile" ]; then
        WRAPPER_JAR="$jarfile"
        break
    fi
done

if [ -z "$WRAPPER_JAR" ]; then
    echo "Gradle wrapper jar not found"
    exit 1
fi

# Execute
exec java -cp "$WRAPPER_JAR" org.gradle.wrapper.GradleWrapperMain "$@"