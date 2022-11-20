package com.example.demo.PracticeProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MainRunner {
	
	 //static TestNG testng;
	 public static void main(String args[]) throws Exception {
		 /*
		 src obj=new src();
		 obj.m1();*/
		 ProcessBuilder builder = new ProcessBuilder(
		            "cmd.exe", "/c", "mvn test -Denv=abc,abc -file "+System.getProperty("user.dir")+"/pom.xml");
		        builder.redirectErrorStream(true);
		        Process p = builder.start();
		        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		        String line;
		        while (true) {
		            line = r.readLine();
		            if (line == null) { break; }
		            System.out.println(line);
		        }
		 /*testng=new TestNG();
		 String path =System.getProperty("user.dir")+"/suite.xml";
		 List<String> xmlList=new ArrayList<String>();
		 xmlList.add(path);
		 
		 testng.setTestSuites(xmlList);
		 testng.run();*/
		 
	 }
}
