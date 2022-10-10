package lotto.ui;

import lotto.domain.LottoNumberList;
import lotto.domain.Money;

import java.util.Arrays;
import java.util.Scanner;

public class LottoInput {

    public static Money money() {
        Scanner scanner = new Scanner(System.in);
        return new Money(scanner.nextInt());
    }

    public static LottoNumberList winnerNumbers() {
        Scanner scanner = new Scanner(System.in);
        return LottoNumberList.createLottoNumbers(
                Arrays.stream(scanner.nextLine().split(", ")).mapToInt(i -> Integer.parseInt(i)).toArray()
        );
    }
}
