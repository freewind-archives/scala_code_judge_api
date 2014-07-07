#!/bin/bash

heroku apps:destroy scala-code-judge-api --confirm
heroku apps:create scala-code-judge-api

git checkout master
git add build_version
git commit -m "update build_version file"

git remote add heroku git@heroku.com:scala-code-judge-api.git
git push heroku master
