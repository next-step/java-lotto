package lotto.step2.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private static final String DELIMITER = ",";
    private static final int LOTTO_COUNT = 6;

    public static List<Integer> isCorrectLottoNumbers(String str) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] numbers = str.split(DELIMITER);
        for (String element : numbers) {
            String trim = element.trim();
            int number = Integer.valueOf(trim);
            winningNumbers.add(number);
        }
        isCorrectLottoCount(winningNumbers);
        isValidLotto(winningNumbers);
        return winningNumbers;
    }

    public static void isCorrectLottoCount(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 당첨 번호는 " + LOTTO_COUNT + "개 이어야 합니다.");
        }
    }

    public static void isValidLotto(List<Integer> lottoNumbers) {
        Set<Integer> set = new HashSet<>(lottoNumbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

}
