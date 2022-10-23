package lotto.view.lotto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LottoInput {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static int purchaseManualAmount() {
        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (Exception e) {
            LottoOutput.purchaseManualAmountInputException();
        }
        return purchaseManualAmount();
    }

    public static int[] lottoNumbers(String lottoNumberDelimiter) {
        try {
            return Arrays.stream(bufferedReader.readLine().split(lottoNumberDelimiter))
                    .mapToInt(i -> Integer.parseInt(i))
                    .toArray();
        } catch (Exception e) {
            LottoOutput.lottoNumbersInputException();
        }
        return lottoNumbers(lottoNumberDelimiter);
    }

    public static int bonusNumber() {
        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (Exception e) {
            LottoOutput.bonusNumberInputException();
        }
        return bonusNumber();
    }
}
