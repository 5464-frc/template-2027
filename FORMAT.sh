#!/usr/bin/env bash
set -xe
./gradlew :spotlessDiagnose
./gradlew :spotlessJavaCheck
./gradlew :spotlessJavaApply