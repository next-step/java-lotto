package lotto;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputBuyLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int buyPrice = scanner.nextInt();
        LottoGameService.setLottoBuyAmt(buyPrice);
        return buyPrice;
    }

    public static void inputWinnerLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] inputNumbers = scanner.next().replaceAll(" ", "").split(",");
        LottoGameService.setWinnerLottoNumbers(Arrays.stream(inputNumbers).mapToInt(Integer::parseInt).toArray());
    }
}
