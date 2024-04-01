# modules-jlink-sample


```shell
javac -d mods/com.foo.bar/ com.foo.bar/module-info.java com.foo.bar/com/foo/bar/HelloWorld.java
```

```shell
mkdir mlib
```

```shell
jar --create --file=mlib/com.foo.bar.hello.jar --module-version=0.0.1 --main-class=com.foo.bar.HelloWorld -C mods/com.foo.bar/ .
```
