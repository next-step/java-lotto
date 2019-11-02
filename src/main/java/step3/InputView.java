package step3;


import java.util.Scanner;

public class InputView {
    private static Scanner scan = new Scanner(System.in);

    public static int inputCash() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scan.nextLine());
    }

    public static String[] inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] inputWinningNumbers = scan.nextLine().split(",");

        for (int i = 0; i < LottoGenerator.WINNING_NUMBERS_LENGTH; i++) {
            inputWinningNumbers[i] = inputWinningNumbers[i].trim();
        }
        return inputWinningNumbers;
    }

    public static void bonusNumberAdd(Lotto inputWinningLottoNumberList) {
        System.out.println("보너스 볼을 입력해주세요.");
        Lotto.lottoBonusNumber = scan.nextInt();
        LottoNo.checkBonusNumber(inputWinningLottoNumberList);
    }
}
