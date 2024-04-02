package lotto.view;

import lotto.domain.Cash;
import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static Cash generateCash() {
        return new Cash(insertNumber());
    }

    public static List<LottoNumber> generateNumbers() {
        String str = insertValues();
        return Arrays.stream(str.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static int insertNumber() {
        return new Scanner(System.in).nextInt();
    }

    private static String insertValues() {
        return new Scanner(System.in).nextLine();
    }
}
