package lottogame.model;


import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    final static int LOTTO_MAX_NUM = 45;
    final static int LOTTO_MIN_NUM = 1;

    private static List<LottoNumber> numbers = new ArrayList<>();

    static {
        for (int i = LOTTO_MIN_NUM; i <= LOTTO_MAX_NUM; i++) {
            numbers.add(new LottoNumber(i));
        }
    }
}
