#!/bin/bash +x

heroku apps:destroy -a scala-code-judge-api --confirm scala-code-judge-api
heroku apps:create scala-code-judge-api

# commit build_version in another branch
git branch -d heroku 2>/dev/null
git branch heroku
git checkout heroku

git add build_version -f
git commit -m "update build_version file"

# push latest code to heroku with build_version
git remote add heroku git@heroku.com:scala-code-judge-api.git 2>/dev/null
git push heroku master

# ckeckout to master and remove heorku branch
git checkout master
git branch -d heroku
