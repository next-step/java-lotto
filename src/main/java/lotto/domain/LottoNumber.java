package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumber {

    private static final int LOTTO_NUMBER_MINIMUM = 1;
    private static final int LOTTO_NUMBER_MAXIMUM = 45;
    private static final List<Integer> lottoNumberList = new ArrayList<>();
    private final int number;

    public LottoNumber(int number) {
        lottoNumberAvailable(number);
        this.number = number;
    }

    public void lottoNumberAvailable(int number) {
        if (number > LOTTO_NUMBER_MAXIMUM || number < LOTTO_NUMBER_MINIMUM) {
            throw new IllegalArgumentException("유효하지 않은 로또 숫자");
        }
    }

    public int getNumber() {
        return number;
    }

    public static List<Integer> getLottoNumberList() {
        if (lottoNumberList.isEmpty()) {
            for (int i = LOTTO_NUMBER_MINIMUM; i <= LOTTO_NUMBER_MAXIMUM; i++) {
                lottoNumberList.add(i);
            }
        }
        return lottoNumberList;
    }
}
