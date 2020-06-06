package study2.view;

import java.util.Scanner;

public class ResultView {
	
	private static final String rankMessages ="당첨 통계";
	private static final String dividMessages = "----------";
	
	static Scanner scanner = new Scanner(System.in);
	
	public void outPutMessages() { 
		System.out.println(rankMessages);
		System.out.println(dividMessages);
	}
	
	
}
