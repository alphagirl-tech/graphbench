#!/bin/bash
if [ "$#" -eq  "4" ] 
	then
mkdir pageR
javac -cp $PGX_HOME/lib/*:$PGX_HOME/third-party/* pageRank.java -d pageR/
java -Dlog4j.configuration=file:$PGX_HOME/conf/log4j.xml -cp $PGX_HOME/lib/*:$PGX_HOME/third-party/*:pageR pageRank $1 $2 $3 $4
else
echo "usage: pagerank <graph config path> <max error value:eg 0.001>
	  <damping factor: ususally 0.85> <max number of iterations: eg 100>"
fi
