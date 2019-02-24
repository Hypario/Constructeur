#!/bin/bash

if [ ! -d "bin" ]; then
   mkdir bin
fi

find src -name *.java -print >javafiles
javac -d bin -source 8 -target 8 @javafiles
jar -cvfe builder-${USER}.jar Main -C bin/ .
