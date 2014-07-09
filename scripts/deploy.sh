#!/bin/bash +x

heroku apps:destroy -a scala-code-judge-api --confirm scala-code-judge-api
heroku apps:create scala-code-judge-api

git status
git checkout master

git status
git add build_version
git commit -m "update build_version file"

git remote add heroku git@heroku.com:scala-code-judge-api.git
git status
git push heroku master
