package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoInput {

    private static final Scanner SCANNER = new Scanner(System.in);

    private LottoInput() {
    }

    public static int inputPrice() {
        return SCANNER.nextInt();
    }

    public static Lotto inputWinningNumber() {
        String input = SCANNER.next();
        return new Lotto(Arrays.stream(input.split(","))
            .mapToInt(Integer::new)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
    }

    public static int inputBonusBall() {
        return SCANNER.nextInt();
    }

}
