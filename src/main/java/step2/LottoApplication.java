package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoApplication {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        final int inputAmount = scanner.nextInt();

        final int numberOfPurchases = getNumberOfPurchases(inputAmount);
        System.out.printf("%d개를 구매했습니다.\n", numberOfPurchases);
        final Lottos issueLottos = issueLottos(numberOfPurchases);
        System.out.print(issueLottos);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        final String inputLastWeekWinningNumbers = scanner.next();
        convertStringToListOfNumber(inputLastWeekWinningNumbers);
    }

    public static int getNumberOfPurchases(int inputValue) {
        return inputValue / LOTTO_PRICE;
    }

    public static Lottos issueLottos(int numberOfPurchases) {
        return new Lottos(numberOfPurchases);
    }

    public static List<Integer> convertStringToListOfNumber(String input) {
        final String[] split = input.replaceAll(" ", "").split(",");
        return Arrays.stream(split)
                .map(Integer::valueOf)
                .collect(Collectors
                        .toList());
    }
}
