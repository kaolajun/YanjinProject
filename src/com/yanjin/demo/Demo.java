package com.yanjin.demo;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;



/**
 * 生产者和消费者问题
 * @author test
 *
 */
/**
 * @param args
 */
class Info{
	private String root;
	private String title;
	private String content; 
	private boolean flag = true;  
//	flag为true表示可以生产但是不能取出
//	flag为false则可以取出，不能生产
	public synchronized void set(String title,String content) {
		//如果flag为false表示不能生产
		if(this.flag == false) {
			try {
				super.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.title = title;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.content = content;
		this.flag = false;   //修改生产标记
		super.notify();  //唤醒其他等待线程
	}
	public synchronized void get() {
		if(this.flag == true) {
			try {
				super.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.title + " - " + this.content);
		this.flag = true;
		super.notify();
	} 
		
}

class Productor implements Runnable{
	private Info info;

	public Productor(Info info) {
		this.info = info;
		
	}
	@Override
	public void run() {
		for(int x = 0; x < 100 ; x++) {
		if(x % 2 == 0) {
			this.info.set("偶数","偶数" + x);
		}else {
			this.info.set("奇数","奇数" + x);
			}	
		}
		
	}
}
class Consumer implements Runnable{
	private Info info;
	public Consumer(Info info) {
		this.info = info;
	}
	
	@Override
	public void run() {
		for (int x = 0 ; x < 100 ; x++) {
			this.info.get();
		}
	}
}
	
public class Demo {

	public static void main(String[] args) {
		Locale zhLoc = new Locale("zh","CN");
		Locale enLoc = new Locale("en","US");
		ResourceBundle zhRb = ResourceBundle.getBundle("My",zhLoc);
		ResourceBundle enRb = ResourceBundle.getBundle("My",enLoc);
		System.out.println(MessageFormat.format(zhRb.getString("country"), "欢迎"));
		System.out.println(MessageFormat.format(enRb.getString("country"), "welcome !"));
		
	}

}
