#! /bin/bash

for dire in ./test/*
do
#  echo  Java output
#  java -cp 'C:\Users\filip\Desktop\Java\ppj-1\out\production\ppj-1\'  LexerTest < $dire/test.in > file123.txt
#  echo Difs output
  difs="$(java -cp 'C:\Users\filip\Desktop\Java\ppj-1\out\production\ppj-1\'  LexerTest < $dire/test.in  | diff $dire/test.out -)"
  #	java -classpath 'C:\Users\filip\IdeaProjects\ComputingTheory-lab1\out\production\ComputingTheory-lab1'  Automat < "$dire/test.a" > text.txt
	if [ "$difs" = "" ];
	then
		echo "$dire : [OK]"
	else
		echo "$dire : "
    echo "$difs"
	fi

done