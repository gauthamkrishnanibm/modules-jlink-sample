package com.foo.bar;

import java.util.logging.Logger;

public class HelloWorld {
  private static final Logger LOG = Logger.getLogger(HelloWorld.class.getName());
  public static void main(String[] args) {
    LOG.info("Hello World!");
  }
}
