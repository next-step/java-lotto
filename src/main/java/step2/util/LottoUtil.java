package step2.util;

import java.util.ArrayList;
import java.util.List;

public class LottoUtil {

    private static final int LOTTO_PRICE = 1000;

    public static int getNumOfTickets(int purchasedAmount) {
        return purchasedAmount / LOTTO_PRICE;
    }

    public static List<Integer> splitStringToNumbers(String winningNumbers) {
        String[] splitNumbers = winningNumbers.split("[ ,]+");
        List<Integer> numbers = new ArrayList<>();

        for (String splitNumber : splitNumbers) {
            numbers.add(Integer.parseInt(splitNumber));
        }
        return numbers;
    }

    public static List<Integer> generateLottoNumbers(List<Integer> lottoNumberRange) {
        return lottoNumberRange.subList(0, 6);
    }
}
