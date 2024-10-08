package lotto.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    private final static String WINNING_NUMBERS_SEPERATOR = ", ";

    private final List<Integer> winningNumbers;

    public WinningNumbers WinningNumbers(final String numbers){
        LottoValidator.validate(numbers);
        return new WinningNumbers(createNumbers(numbers));
    }

    public WinningNumbers(final List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    private static List<Integer> createNumbers(String numbers) {
        String[] splitNumbers = splitNumbers(numbers);
        List<Integer> lottoNumbers = new ArrayList<Integer>();

        for (String number: splitNumbers) {
            int lottoNumber = Integer.parseInt(number);
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }

    private static String[] splitNumbers(String numbers) {
        return numbers.split(WINNING_NUMBERS_SEPERATOR);
    }

    public int matchWinningNumber(Lotto lotto) {
        int matchCount = 0;
        for (Integer winningNumber : winningNumbers) {
            if(lotto.hasNumber(winningNumber)) matchCount++;
        }
        return matchCount;

    }
}
