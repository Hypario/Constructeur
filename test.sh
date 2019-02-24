#!/bin/bash
exitcode=0

for f in `ls testfiles/*.md `;
do 
   echo "Testing $f"
   java -jar builder-${USER}.jar $f | diff ${f%.md}.html -
   exitcode=$((exitcode + $?)) 
done 

exit $exitcode
