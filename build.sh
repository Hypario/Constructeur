#!/bin/bash
# if bin directory does not exists, create it
if [ ! -d "bin" ]; then
   mkdir bin
fi
exitcode=0
# retrieve java files to compile
find src -name *.java -print >javafiles
# compile the files for java 8+ and create a jar file
export LC_ALL=en_US.UTF-8
export LANG=en_US.UTF-8
export LANGUAGE=en_US.UTF-8
javac -d bin -source 8 -target 8 @javafiles && \
jar -cvfe builder-${USER}.jar Main -C bin/ .
