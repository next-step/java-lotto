package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LastWeekLottoNumbers {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private List<Integer> lottoNumbers;

    public LastWeekLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new RuntimeException("6개의 로또 번호를 입력해 주세요.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    private static LastWeekLottoNumbers stringArrayToIntegerList(String[] lottoStrings) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoStrings.length; i++) {
            lottoNumbers.add(lottoNumberBoundCheck(Integer.parseInt(removeSpace(lottoStrings[i]))));
        }
        return new LastWeekLottoNumbers(lottoNumbers);
    }

    private static Integer lottoNumberBoundCheck(int lottoNumber) {
        if (lottoNumber > MAX_LOTTO_NUMBER || lottoNumber < MIN_LOTTO_NUMBER) {
            throw new RuntimeException("가능한 로또번호가 아닙니다.");
        }
        return lottoNumber;
    }

    private static String removeSpace(String lottoString) {
        return lottoString.replaceAll("\\s", "");
    }

}
