# Sample to demonstrate modules and jlink

Step 1: Compile the classes
```shell
javac -d mods/com.foo.bar/ com.foo.bar/module-info.java com.foo.bar/com/foo/bar/HelloWorld.java
```
Step 2: Create jar file
```shell
mkdir mlib
```
```shell
jar --create --file=mlib/com.foo.bar.hello.jar --module-version=0.0.1 --main-class=com.foo.bar.HelloWorld -C mods/com.foo.bar/ .
```

Step 3: Test the JAR file to make sure that it’s working
```shell
java --module-path=mlib --module=com.foo.bar
```
output:
```shell
Hola, Mundo!
```
```shell
java --module-path=mlib --describe-module com.foo.bar
```
output:
```shell
com.foo.bar@0.0.1 file:///Users/z0ltan/dev/playground/helloworld_jlink/mlib/com.foo.bar.hello.jar
requires java.base mandated
contains com.foo.bar
```

Step 4: Creating a custom runtime image using jlink
```shell
jlink --module-path=$JAVA_HOME/jmods:mlib --add-modules=com.foo.bar --output=testRuntimeImage --strip-debug --no-header-files
contains com.foo.bar
```

step5: Running the application from the custom runtime image
```shell
./testRuntimeImage/bin/java --module com.foo.bar
bin/java --module com.foo.bar
```
output:
```shell
Hola, Mundo!
contains com.foo.bar
```




