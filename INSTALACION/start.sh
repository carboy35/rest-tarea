#!/bin/bash 

if [ "$1" != "" ]; then
  PORT=--server.port=$1
fi

nohup java -Xmx128m -Xss256k -jar rest-tarea-0.0.1.JAR --spring.config.name=application $PORT > output.log 2>&1&
echo $! > pid

