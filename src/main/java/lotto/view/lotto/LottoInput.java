package lotto.view.lotto;

import lotto.domain.Amount;
import lotto.domain.lottonumber.LottoNumber;
import lotto.domain.lottonumber.LottoNumberSet;

import java.util.Arrays;
import java.util.Scanner;

public class LottoInput {

    public static Amount purchaseManualAmount() {
        Scanner scanner = new Scanner(System.in);
        try {
            return new Amount(scanner.nextInt());
        } catch (Exception e) {
            LottoOutput.purchaseManualAmountInputException();
        }
        return purchaseManualAmount();
    }

    public static LottoNumberSet lottoNumbers() {
        Scanner scanner = new Scanner(System.in);
        try {
            return LottoNumberSet.createLottoNumberSet(
                    Arrays.stream(scanner.nextLine().split(LottoNumberSet.LOTTONUMBERSET_DELIMITER))
                            .mapToInt(i -> Integer.parseInt(i))
                            .toArray());
        } catch (Exception e) {
            LottoOutput.lottoNumbersInputException();
        }
        return lottoNumbers();
    }

    public static LottoNumber bonusNumber() {
        Scanner scanner = new Scanner(System.in);
        try {
            return new LottoNumber(scanner.nextInt());
        } catch (Exception e) {
            LottoOutput.bonusNumberInputException();
        }
        return bonusNumber();
    }
}
