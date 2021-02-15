package com.mynameis.util.log;

import java.net.URL;
import java.net.URLClassLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class LogUtilTest {
    static {
        LogUtils.configureLogging();
    }

    public static void main(final String[] args) {
        printClasspath();
        final Logger logger = LoggerFactory.getLogger(LogUtilTest.class);
        logger.info("Hello World");

        final LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);

    }

    private static void printClasspath() {
        final ClassLoader cl = ClassLoader.getSystemClassLoader();
        final URL[] urls = ((URLClassLoader) cl).getURLs();
        for (final URL url : urls) {
            System.out.println(url.getFile());
        }
    }
}
