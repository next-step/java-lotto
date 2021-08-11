package lotto.step2.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private static final String DELIMITER = ",";
    private static final int LOTTO_COUNT = 6;

    public static List<LottoNumber> isCorrectLottoNumbers(String str) {
        List<LottoNumber> winningNumbers = new ArrayList<>();
        String[] numbers = str.split(DELIMITER);
        for (String element : numbers) {
            String trim = element.trim();
            int number = Integer.valueOf(trim);
            winningNumbers.add(new LottoNumber(number));
        }
        isCorrectLottoCount(winningNumbers);
        isValidLotto(winningNumbers);
        return winningNumbers;
    }

    public static void isCorrectLottoCount(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 당첨 번호는 " + LOTTO_COUNT + "개 이어야 합니다.");
        }
    }

    public static void isValidLotto(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> set = new HashSet<>(lottoNumbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

}
