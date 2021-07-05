#!/bin/bash

set -eou pipefail

# install certs
if command -v mkcert &> /dev/null; then
  mkcert -install -pkcs12 localhost
  cp localhost.p12 ./api/src/main/resources/
  cp localhost.p12 ./adfs/src/main/resources/
  cp localhost.p12 ./azure-ad/src/main/resources/
  cp localhost.p12 ./azure-b2c/src/main/resources/
  rm localhost.p12
else
  echo You must install mkcert
fi