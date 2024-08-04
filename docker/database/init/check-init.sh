#!/bin/bash
set -eo pipefail
shopt -s nullglob

if [ ! -f /var/lib/mysql/.initialized ]; then
    echo "First-time initialization, setting autocommit 1"
    touch /var/lib/mysql/.initialized
    touch /var/lib/mysql/.autocommit.cnf
    echo '[mysqld]' >> /var/lib/mysql/.autocommit.cnf
    echo 'autocommit=1' >> /var/lib/mysql/.autocommit.cnf
    echo "First-time initialization, End"
else
    echo "Subsequent startup, setting autocommit to 0"
    echo "[mysqld]" > /var/lib/mysql/.autocommit.cnf
    echo "autocommit=0" >> /var/lib/mysql/.autocommit.cnf
fi