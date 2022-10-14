package lotto.ui;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberSet;
import lotto.domain.Money;

import java.util.Arrays;
import java.util.Scanner;

public class LottoInput {

    public static Money money() {
        Scanner scanner = new Scanner(System.in);
        return new Money(scanner.nextInt());
    }

    public static LottoNumberSet winnerNumbers() {
        Scanner scanner = new Scanner(System.in);
        return LottoNumberSet.createLottoNumberSet(
                Arrays.stream(scanner.nextLine().split(", ")).mapToInt(i -> Integer.parseInt(i)).toArray()
        );
    }

    public static LottoNumber bonusNumber() {
        Scanner scanner = new Scanner(System.in);
        return new LottoNumber(scanner.nextInt());
    }
}
