#!/bin/bash

set -eou pipefail

# install certs
if command -v mkcert &> /dev/null; then
  mkcert -install -pkcs12 localhost
  cp localhost.p12 ./client-credentials/src/main/resources/
  rm localhost.p12
else
  echo You must install mkcert
fi