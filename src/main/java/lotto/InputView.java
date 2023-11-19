package lotto;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StringBuilder sb = new StringBuilder();
    private static final long LOTTO_PRICE = 1000;

    public static int inputPurchaseCount() {
        System.out.println("구입금액을 입력해주세요");
        int purchaseAmount = scanner.nextInt();
        int purchaseCount = (int) (purchaseAmount / LOTTO_PRICE);
        System.out.printf("%d개를 구매했습니다.\n", purchaseCount);

        return purchaseCount;
    }

    private static void printLottoList(Lotto lotto) {
        sb.setLength(0);
        sb.append("[");

        for (LottoNumber lottoNumber : lotto) {
            sb.append(lottoNumber.lottoNumber());
            sb.append(", ");
        }

        sb.setLength(sb.length() - 2);
        sb.append("]");

        System.out.println(sb);
    }

    public static String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputNumbers = scanner.next();

        return inputNumbers;
    }
}
