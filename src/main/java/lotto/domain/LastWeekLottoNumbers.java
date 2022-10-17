package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.constant.LottoNumber.*;

public class LastWeekLottoNumbers {
    private List<Integer> lottoNumbers;

    public LastWeekLottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public static LastWeekLottoNumbers createLottoNumbers(String[] lottoStrings) {
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoLengthCheck(lottoStrings);
        for (int i = 0; i < lottoStrings.length; i++) {
            lottoNumbers.add(lottoNumberBoundCheck(Integer.parseInt(removeSpace(lottoStrings[i]))));
        }
        return new LastWeekLottoNumbers(lottoNumbers);
    }

    private static void lottoLengthCheck(String[] lottoStrings) {
        lottoStrings = Arrays.stream(lottoStrings).distinct().toArray(String[]::new);
        if (lottoStrings.length != LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER + "개의 로또 번호를 입력해 주세요.");
        }
    }

    private static Integer lottoNumberBoundCheck(int lottoNumber) {
        if (lottoNumber > MAX_LOTTO_NUMBER || lottoNumber < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException("가능한 로또번호가 아닙니다.");
        }
        return lottoNumber;
    }

    private static String removeSpace(String lottoString) {
        return lottoString.replaceAll("\\s", "");
    }

    public boolean contains(Integer integer) {
        return lottoNumbers.contains(integer);
    }
}
