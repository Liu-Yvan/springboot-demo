#!/bin/bash
java $JAVA_OPTS -jar $JAR_PATH $APP_OPTS &
PID=$!
echo ${PID} > app.pid
trap "kill -15 ${PID} && wait ${PID}" SIGTERM
wait ${PID}
