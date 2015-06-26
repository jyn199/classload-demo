package com.jyn.demo.classload;

import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ClassLoadTest {

	private void getClassLoad(){
		/*
		 * 引导类加载器（bootstrap class loader）： 它用来加载 Java 的核心库，是用原生代码来实现的，并不继承自
		 * java.lang.ClassLoader。
		 */
		System.out.println(String.class.getClassLoader());
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (int i = 0; i < urls.length; i++) {
			System.out.println(urls[i].toExternalForm());
		}

		/*
		 * 扩展类加载器（extensions class loader）： 它用来加载 Java 的扩展库。Java
		 * 虚拟机的实现会提供一个扩展库目录。该类加载器在此目录里面查找并加载 Java 类。
		 */
		System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class
				.getClassLoader());
		
		System.out.println(System.getProperty("java.ext.dirs"));

		/*
		 * 系统类加载器（system class loader）： 它根据 Java 应用的类路径（CLASSPATH）来加载 Java 类。
		 * 一般来说，Java 应用的类都是由它来完成加载的。可以通过 ClassLoader.getSystemClassLoader()来获取它。
		 */
		System.out.println(ClassLoadTest.class.getClassLoader());
		System.out.println(this.getClass().getClassLoader());
		System.out.println(System.getProperty("java.class.path"));
		
		
		/*
		 * 线程上下文类加载器
		 */
		System.out.println(Thread.currentThread().getContextClassLoader());

	}

	public static void main(String[] args) {
		ClassLoadTest clt = new ClassLoadTest();
		clt.getClassLoad();
	}
}
