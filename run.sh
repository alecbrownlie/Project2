#!/bin/bash
# run Project 2 Application
cd src
javac com/main/Application.java
java com/main/Application
cd ..
rm src/com/*/*.class
