package lotto.step2.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private static final String DELIMITER = ",";
    private static final int LOTTO_COUNT = 6;

    public static Set<LottoNumber> isCorrectLottoNumbers(String str) {
        Set<LottoNumber> winningNumbers = new HashSet<>();
        String[] numbers = str.split(DELIMITER);
        for (String element : numbers) {
            String trim = element.trim();
            int number = Integer.valueOf(trim);
            winningNumbers.add(new LottoNumber(number));
        }
        isCorrectLottoCount(winningNumbers);
        return winningNumbers;
    }

    public static void isCorrectLottoCount(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 당첨 번호는 " + LOTTO_COUNT + "개 이어야 합니다.");
        }
    }


}
