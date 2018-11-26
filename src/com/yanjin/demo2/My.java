package com.yanjin.demo2;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;


public class My {
	public static void main(String[] args) {
		Department dp1 = new Department(1,"人事部","三楼");
		Department dp2 = new Department(2,"技术部","一楼");
		Department dp3 = new Department(3,"硬件部","二楼");
		
		Employee emp1 = new Employee(1, dp1, "李四", "部长", null , 9000.55);
		Employee emp2 = new Employee(2, dp1, "张三", "员工", emp1 , 2000.23);
		Employee emp3 = new Employee(3, dp2, "王五", "部长", null , 2000.23);
		
		dp1.getEmps().add(emp1);
		dp1.getEmps().add(emp2);
		
		Iterator<Employee> iter = dp1.getEmps().iterator();
		System.out.println(dp1);
		while(iter.hasNext()) {
			System.out.println(iter.next());
			System.out.println("**********************************************");
		}
	}
}

	

