package lotto.ui;

import lotto.domain.Amount;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumberSet;
import lotto.domain.Money;

import java.util.Arrays;
import java.util.Scanner;

public class LottoInput {

    public static Money money() {
        Scanner scanner = new Scanner(System.in);
        return new Money(scanner.nextInt());
    }

    public static Amount purchaseManualAmount() {
        Scanner scanner = new Scanner(System.in);
        return new Amount(scanner.nextInt());
    }

    public static LottoNumberSet lottoNumbers() {
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
