package lotto.view.lotto;

import java.util.Arrays;
import java.util.Scanner;

public class LottoInput {

    private static final Scanner scanner = new Scanner(System.in);

    public static int purchaseManualAmount() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            LottoOutput.purchaseManualAmountInputException();
        }
        return purchaseManualAmount();
    }

    public static int[] lottoNumbers(String lottoNumberDelimiter) {
        try {
            return Arrays.stream(scanner.nextLine().split(lottoNumberDelimiter))
                    .mapToInt(i -> Integer.parseInt(i))
                    .toArray();
        } catch (Exception e) {
            LottoOutput.lottoNumbersInputException();
        }
        return lottoNumbers(lottoNumberDelimiter);
    }

    public static int bonusNumber() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            LottoOutput.bonusNumberInputException();
        }
        return bonusNumber();
    }
}
