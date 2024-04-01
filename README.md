# Sample to demonstrate modules and jlink

Requires Java.

## Environment Setup
To run this sample, first download zip or clone this repo - to clone:
```shell
git clone git@github.com:gauthamkrishnanibm/modules-jlink-sample.git
```

## Step 1: Compile the classes
```shell
javac -d mods/com.foo.bar/ com.foo.bar/module-info.java com.foo.bar/com/foo/bar/HelloWorld.java
```
## Step 2: Create jar file
```shell
mkdir mlib
```
```shell
jar --create --file=mlib/com.foo.bar.hello.jar --module-version=0.0.1 --main-class=com.foo.bar.HelloWorld -C mods/com.foo.bar/ .
```

## Step 3: Test the JAR file to make sure that it’s working
```shell
java --module-path=mlib --module=com.foo.bar
```
output:
```shell
INFO: Hello World!
```
```shell
java --module-path=mlib --describe-module com.foo.bar
```
output:
```shell
com.foo.bar@0.0.1 file:///helloworld_jlink/mlib/com.foo.bar.hello.jar
requires java.base mandated
requires java.logging
contains com.foo.bar
```

## Step 4: Creating a custom runtime image using jlink
```shell
jlink --module-path=$JAVA_HOME/jmods:mlib --add-modules=com.foo.bar --output=testRuntimeImage --strip-debug --no-header-files
contains com.foo.bar
```

## step 5: Running the application from the custom runtime image
```shell
./testRuntimeImage/bin/java --module com.foo.bar
```
output:
```shell
INFO: Hello World!
```

## step 6: Checking only the bare minimum modules have been added
```shell
./testRuntimeImage/bin/java --list-modules com.foo.bar
```
output:
```shell
com.foo.bar@0.0.1
java.base@18.0.2.1
java.logging@18.0.2.1
```






