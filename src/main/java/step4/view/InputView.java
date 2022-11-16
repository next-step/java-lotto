package step4.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

	private final static Scanner scanner = new Scanner(System.in);

	public static int inputPurchaseAmount(){
		System.out.println("구입금액을 입력해 주세요.");
		return scanner.nextInt();
	}

	public static int inputPurchaseManualLottoCnt(){
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		return scanner.nextInt();
	}

	public static List<String> inputManualLottoNum(int manualLottoCnt){
		scanner.nextLine();
		System.out.println("수동으로 구매할 번호를 입력해주세요");
		return IntStream.range(0, manualLottoCnt).mapToObj(i -> scanner.nextLine()).collect(Collectors.toList());
	}

	public static String inputLastWeekWinnerNumber(){
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return scanner.nextLine();
	}

	public static int inputBonusBall(){
		System.out.println("보너스 볼을 입력해 주세요.");
		return scanner.nextInt();
	}
}
