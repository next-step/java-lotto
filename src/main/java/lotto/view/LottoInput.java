package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoInput {

    private static final Scanner SCANNER = new Scanner(System.in);

    private LottoInput() {
    }

    public static int inputPrice() {
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static List<LottoNumber> inputWinningNumber() {
        String input = SCANNER.nextLine();
        return Arrays.stream(splitWinningNumber(input))
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    private static String[] splitWinningNumber(final String input) {
        return input.replace(" ", "").split(",");
    }

    public static int inputBonusBall() {
        return Integer.parseInt(SCANNER.nextLine());
    }

}
