package com.yanjin.demo;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;



/**
 * �����ߺ�����������
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
//	flagΪtrue��ʾ�����������ǲ���ȡ��
//	flagΪfalse�����ȡ������������
	public synchronized void set(String title,String content) {
		//���flagΪfalse��ʾ��������
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
		this.flag = false;   //�޸��������
		super.notify();  //���������ȴ��߳�
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
			this.info.set("ż��","ż��" + x);
		}else {
			this.info.set("����","����" + x);
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
		System.out.println(MessageFormat.format(zhRb.getString("country"), "��ӭ"));
		System.out.println(MessageFormat.format(enRb.getString("country"), "welcome !"));
		
	}

}
