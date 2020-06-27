package study4.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import study4.domain.Lotto;

public class InputView {
	private static final String INIT_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String WIN_RANK_MESSAGE = "지난 주 당첨 번호를 입력해 주세요";
	private static final int LOTTO_PRICE = 1000;
	private static final String BONUS_MESSAGE = "보너스 볼을 입력해 주세요.";
	private static final String MANNUAL_LOTTOS_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String MANNUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
	
	
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
		
		return inputPrice;
	}
	
	public static int manualLottoNumber() {
		
		System.out.println(MANNUAL_LOTTOS_COUNT);
		int manualCount = scanner.nextInt() ;
		return manualCount * LOTTO_PRICE;
	}
	
	public static List<String> inputNumberByManual(int mannualLottoNumbers) {
		
		scanner.nextLine();
		System.out.println(MANNUAL_LOTTO_NUMBERS);
		
		List<String> mannualLottos = new ArrayList<>(); 
		for(int i=0; i< mannualLottoNumbers / LOTTO_PRICE ; i++) {
			mannualLottos.add(scanner.nextLine());
		}
		return mannualLottos;
	}
	
	private static boolean negativePrice(int inputPrice) {
		return inputPrice< LOTTO_PRICE;
	}
	
	public static String rankMessages() {
		System.out.println(WIN_RANK_MESSAGE);
		
		return scanner.nextLine();
	}
}
