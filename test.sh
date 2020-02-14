#!/bin/bash
exitcode=0
RED='\033[0;31m'
GREEN='\033[0;32m'
NONE='\033[0m' 
for f in `ls testfiles/*.md `;
do 
   echo "Testing $f"
   java -jar builder-${USER}.jar $f | diff ${f%.md}.html -
   pass=$?
   exitcode=$((exitcode || pass)) 
   if [ $pass -eq 0 ]; then 
      echo -e "${GREEN}OK${NONE}" 
    else 
      echo -e "${RED}KO${NONE}" 
    fi
done 
if [ $exitcode -eq 0 ]; then 
      echo -e "${GREEN}All tests pass${NONE}" 
    else 
      echo -e "${RED}Some test(s) fail(s)${NONE}" 
    fi
exit $exitcode
