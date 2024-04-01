# modules-jlink-sample

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

