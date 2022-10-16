package lotto.view;

import lotto.domain.Amount;
import lotto.domain.Money.ImmutableMoney;
import lotto.domain.lottonumber.LottoNumber;
import lotto.domain.lottonumber.LottoNumberSet;

import java.util.Arrays;
import java.util.Scanner;

public class LottoInput {

    public static ImmutableMoney money() {
        Scanner scanner = new Scanner(System.in);
        return new ImmutableMoney(scanner.nextInt());
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
