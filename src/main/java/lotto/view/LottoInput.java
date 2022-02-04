package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.LottoNumbers;

public class LottoInput {

    private static final Scanner SCANNER = new Scanner(System.in);

    private LottoInput() {
    }

    public static int inputPrice() {
        return SCANNER.nextInt();
    }

    public static LottoNumbers inputWinningNumber() {
        String input = SCANNER.next();
        return new LottoNumbers(Arrays.stream(input.split(","))
            .mapToInt(Integer::new)
            .boxed()
            .collect(Collectors.toList()));
    }

    public static int inputBonusBall() {
        return SCANNER.nextInt();
    }

}
