package study2.view;

import java.util.Arrays;
import java.util.Scanner;

import study2.domain.Lotto;

public class InputView {
	private static final String initMessage = "구입금액을 입력해 주세요.";
	private static final String inputPriceMessage = "개를 구매했습니다.";
	
	static Scanner scanner = new Scanner(System.in);
	
	public static int initMessages() {
		System.out.println(initMessage);
		
		return scanner.nextInt();
	}
	
	public static int inputNumberMessages(int inputPrice) {
		System.out.println(inputPrice / 1000 + inputPriceMessage);
		
		return (inputPrice / 1000);
	}
	
}
