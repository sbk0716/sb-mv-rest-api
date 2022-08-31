# 1. Prerequisites

## Install JDK and Maven
```sh
admin@gw-mac sb-mv-rest-api % /usr/libexec/java_home               
/Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home
admin@gw-mac sb-mv-rest-api % echo $JAVA_HOME
/Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home
admin@gw-mac sb-mv-rest-api % 
admin@gw-mac sb-mv-rest-api % java -version
openjdk version "17.0.4.1" 2022-08-12
OpenJDK Runtime Environment Temurin-17.0.4.1+1 (build 17.0.4.1+1)
OpenJDK 64-Bit Server VM Temurin-17.0.4.1+1 (build 17.0.4.1+1, mixed mode)
admin@gw-mac sb-mv-rest-api % mvn -v       
Apache Maven 3.8.6 (84538c9988a25aec085021c365c560670ad80f63)
Maven home: /opt/homebrew/Cellar/maven/3.8.6/libexec
Java version: 18.0.2.1, vendor: Homebrew, runtime: /opt/homebrew/Cellar/openjdk/18.0.2.1/libexec/openjdk.jdk/Contents/Home
Default locale: en_JP, platform encoding: UTF-8
OS name: "mac os x", version: "12.5.1", arch: "aarch64", family: "mac"
admin@gw-mac sb-mv-rest-api % 
admin@gw-mac sb-mv-rest-api % /usr/libexec/java_home               
/Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home
admin@gw-mac sb-mv-rest-api % echo $JAVA_HOME
/Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home
admin@gw-mac sb-mv-rest-api % 
admin@gw-mac sb-mv-rest-api % brew info maven
==> maven: stable 3.8.6 (bottled)
Java-based project management
https://maven.apache.org/
Conflicts with:
  mvnvm (because also installs a 'mvn' executable)
/opt/homebrew/Cellar/maven/3.8.6 (78 files, 9.7MB) *
  Poured from bottle on 2022-08-31 at 10:25:13
From: https://github.com/Homebrew/homebrew-core/blob/HEAD/Formula/maven.rb
License: Apache-2.0
==> Dependencies
Required: openjdk ✔
==> Analytics
install: 61,489 (30 days), 215,979 (90 days), 802,742 (365 days)
install-on-request: 61,371 (30 days), 215,335 (90 days), 798,990 (365 days)
build-error: 0 (30 days)
admin@gw-mac sb-mv-rest-api % 
```

## Install mysql
```sh
admin@gw-mac sb-mv-rest-api % brew install mysql
Warning: mysql 8.0.30 is already installed and up-to-date.
To reinstall 8.0.30, run:
  brew reinstall mysql
admin@gw-mac sb-mv-rest-api % mysql --version
mysql  Ver 8.0.30 for macos12.4 on arm64 (Homebrew)
admin@gw-mac sb-mv-rest-api % brew services start mysql
==> Tapping homebrew/services
Cloning into '/opt/homebrew/Library/Taps/homebrew/homebrew-services'...
remote: Enumerating objects: 2090, done.
remote: Total 2090 (delta 0), reused 0 (delta 0), pack-reused 2090
Receiving objects: 100% (2090/2090), 584.66 KiB | 3.56 MiB/s, done.
Resolving deltas: 100% (927/927), done.
Tapped 1 command (45 files, 739.2KB).
==> Successfully started `mysql` (label: homebrew.mxcl.mysql)
admin@gw-mac sb-mv-rest-api % brew services      
Name          Status  User  File
mysql         started admin ~/Library/LaunchAgents/homebrew.mxcl.mysql.plist
postgresql@14 none          
admin@gw-mac sb-mv-rest-api % 
admin@gw-mac sb-mv-rest-api % brew info mysql
==> mysql: stable 8.0.30 (bottled)
Open source relational database management system
https://dev.mysql.com/doc/refman/8.0/en/
Conflicts with:
  mariadb (because mysql, mariadb, and percona install the same binaries)
  percona-server (because mysql, mariadb, and percona install the same binaries)
/opt/homebrew/Cellar/mysql/8.0.30 (312 files, 296.4MB) *
  Poured from bottle on 2022-08-31 at 07:36:11
From: https://github.com/Homebrew/homebrew-core/blob/HEAD/Formula/mysql.rb
License: GPL-2.0-only with Universal-FOSS-exception-1.0
==> Dependencies
Build: cmake ✘, pkg-config ✘
Required: icu4c ✔, libevent ✔, libfido2 ✔, lz4 ✔, openssl@1.1 ✔, protobuf ✔, zlib ✔, zstd ✔
==> Caveats
We've installed your MySQL database without a root password. To secure it run:
    mysql_secure_installation

MySQL is configured to only allow connections from localhost by default

To connect run:
    mysql -uroot

To restart mysql after an upgrade:
  brew services restart mysql
Or, if you don't want/need a background service you can just run:
  /opt/homebrew/opt/mysql/bin/mysqld_safe --datadir=/opt/homebrew/var/mysql
==> Analytics
install: 98,811 (30 days), 276,206 (90 days), 1,062,558 (365 days)
install-on-request: 98,592 (30 days), 275,561 (90 days), 1,059,252 (365 days)
build-error: 277 (30 days)
admin@gw-mac sb-mv-rest-api % 
```

# 2. Create and import Spring Boot project
```sh
admin@gw-mac sb-mv-rest-api % ls -la employee
total 80
drwxr-xr-x@ 13 admin  staff    416 Aug 31 10:33 .
drwxr-xr-x   6 admin  staff    192 Aug 31 08:07 ..
-rw-r--r--   1 admin  staff   1967 Aug 31 10:14 .classpath
-rw-r--r--@  1 admin  staff    395 Aug 30 23:01 .gitignore
drwxr-xr-x@  3 admin  staff     96 Aug 30 23:01 .mvn
-rw-r--r--   1 admin  staff    832 Aug 31 10:14 .project
drwxr-xr-x   5 admin  staff    160 Aug 31 08:05 .settings
-rw-r--r--@  1 admin  staff   1124 Aug 30 23:01 HELP.md
-rwxr-xr-x@  1 admin  staff  10284 Aug 30 23:01 mvnw
-rw-r--r--@  1 admin  staff   6734 Aug 30 23:01 mvnw.cmd
-rw-r--r--@  1 admin  staff   1503 Aug 30 23:01 pom.xml
drwxr-xr-x@  4 admin  staff    128 Aug 30 23:01 src
drwxr-xr-x   4 admin  staff    128 Aug 31 08:05 target
admin@gw-mac sb-mv-rest-api % 
```



# 3. Add sub-packages to the project


# 4. Create table and configure MySQL details in Spring Boot


# 5. Create the model class


# 6. Create the model class



# 7. Create the repository class


# 8. Create the repository class


# 9. Create the controller class

# 10. Create the controller class


