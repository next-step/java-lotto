package study3.view;

import java.util.Arrays;
import java.util.Scanner;

import study3.domain.Lotto;

public class InputView {
	private static final String INIT_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String INPUT_PRICE_MESSAGE = "개를 구매했습니다.";
	private static final String WIN_RANK_MESSAGE = "지난 주 당첨 번호를 입력해 주세요";
	private static final int LOTTO_PRICE = 1000;
	private static final String BONUS_MESSAGE = "보너스 볼을 입력해 주세요.";
	
	static Scanner scanner = new Scanner(System.in);
	
	public static int enterPriceMessage() {
		System.out.println(INIT_MESSAGE);
		
		return scanner.nextInt();
	}
	
	public static int enterBonusBallMessage() {
		System.out.println(BONUS_MESSAGE);
		
		return scanner.nextInt();
	}
	
	public static int inputNumberMessages(int inputPrice) {
		
		if(negativePrice(inputPrice)) {
			throw new IllegalArgumentException("금액은 1000보다 커야합니다.");
		}
		
		System.out.println(inputPrice / LOTTO_PRICE + INPUT_PRICE_MESSAGE);
		
		return inputPrice;
	}
	
	private static boolean negativePrice(int inputPrice) {
		return inputPrice< LOTTO_PRICE;
	}
	
	public static String rankMessages() {
		System.out.println(WIN_RANK_MESSAGE);
		scanner.nextLine();
		return scanner.nextLine();
	}
}
