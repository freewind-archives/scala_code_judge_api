#!/bin/bash
mkdir -p logs
nohup ./bin/scala_code_judger_api -Dhttp.port=10003 >/dev/null 2>&1 &
# You can provide all the -Dsettings you need to set for your application here :-)
