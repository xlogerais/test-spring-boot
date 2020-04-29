#!/bin/bash

SESSION_NAME=springboot

BASEDIR="$HOME/Work/Dev/test-spring-boot"
VERSION="0.0.1-SNAPSHOT"
DEBUG="--debug"

# Create tmux session
tmux new-session -s "${SESSION_NAME}" -d

# Start spring infra (eureka, admin-server, config-server)
tmux new-window  -t "${SESSION_NAME}" -n "eureka"         -c "${BASEDIR}/base" "java -jar eureka/target/eureka-${VERSION}.jar $DEBUG"
tmux new-window  -t "${SESSION_NAME}" -n "config-server"  -c "${BASEDIR}/base" "java -jar config/target/config-${VERSION}.jar $DEBUG"
tmux new-window  -t "${SESSION_NAME}" -n "admin-server"   -c "${BASEDIR}/base" "java -jar admin/target/admin-${VERSION}.jar   $DEBUG"

sleep 30

# Start applications
tmux new-window  -t "${SESSION_NAME}" -n "helloworld"   -c "${BASEDIR}/apps" "java -jar helloworld-api/target/helloworld-api-${VERSION}.jar $DEBUG"
