#!/bin/bash

curl -H "Content-Type: application/json" \
    -X POST -d '{"firstName":"Corbs","lastName":"Martin","login":"corbs@pivotal.io","email":"corbs@pivotal.io","password":"onefishtwofishredfishbluefish"}'\
     http://localhost:8080/users