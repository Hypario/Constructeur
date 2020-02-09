#!/bin/bash
# if bin directory does not exists, create it
if [ ! -d "bin" ]; then
   mkdir bin
fi
exitcode=0
# retrieve java files to compile
find src -name *.java -print >javafiles
# compile the files for java 8+
export LANG=fr_FR.utf8
javac -d bin -source 8 -target 8 @javafiles
exitcode=$((exitcode + $?))
# create an autoexceutable jar file
jar -cvfe builder-${USER}.jar Main -C bin/ .
exitcode=$((exitcode + $?))
# breaks the build if exitcode>0
exit $exitcode
