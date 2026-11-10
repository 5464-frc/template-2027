#!/usr/bin/env bash
set -xe
./gradlew :spotlessDiagnose --no-configuration-cache
./gradlew :spotlessJavaCheck
./gradlew :spotlessJavaApply