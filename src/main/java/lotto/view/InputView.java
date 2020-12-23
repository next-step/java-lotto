package lotto.view;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final String SPLIT_REGEX = ",";
    private static final String EMPTY_REGEX = "\\s+";

    public List<LottoNumber> inputLuckyNumbers(String line) {
        String[] numbers = line
                .replaceAll(EMPTY_REGEX, "")
                .split(SPLIT_REGEX);
        List<LottoNumber> luckyNumbers = new ArrayList<>();
        for (String number : numbers) {
            luckyNumbers.add(new LottoNumber(Integer.parseInt(number)));
        }
        return luckyNumbers;
    }

}
