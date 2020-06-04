package study2.view;

import java.util.Scanner;

public class ResultView {
	
	private static final String initMessage = "구입금액을 입력해 주세요.";
	private static final String inputPriceMessage = "개를 구매했습니다.";
	
	Scanner scanner = new Scanner(System.in);
	
	public int initMessages() {
		System.out.println(initMessage);
		
		return scanner.nextInt();
	}
	
	public void inputNumberMessages(int inputPrice) {
		System.out.println(inputPrice+ inputPriceMessage);
	}
	
}
