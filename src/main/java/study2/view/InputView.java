package study2.view;

import java.util.Arrays;
import java.util.Scanner;

import study2.domain.Lotto;

public class InputView {
	private static final String initMessage = "구입금액을 입력해 주세요.";
	private static final String inputPriceMessage = "개를 구매했습니다.";
	private static final String winRankMessages = "지난 주 당첨 번호를 입력해 주세요";
	private static final int lottoPrice = 1000;
	
	static Scanner scanner = new Scanner(System.in);
	
	public static int enterPriceMessage() {
		System.out.println(initMessage);
		
		return scanner.nextInt();
	}
	
	public static int inputNumberMessages(int inputPrice) {
		
		if(negativePrice(inputPrice)) {
			throw new IllegalArgumentException("금액은 1000보다 커야합니다.");
		}
		
		System.out.println(inputPrice / lottoPrice + inputPriceMessage);
		
		return inputPrice;
	}
	
	private static boolean negativePrice(int inputPrice) {
		return inputPrice< lottoPrice;
	}
	
	public static String rankMessages() {
		System.out.println(winRankMessages);
		scanner.nextLine();
		return scanner.nextLine();
	}
}
