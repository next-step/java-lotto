package step2;

import java.util.List;

public class Lotto {
    public static final int LOTTO_NUMBER_SIZE = 6;

    private final LottoNumbers lottoNumbers;

    public Lotto(List<Integer> valueList) {
        if (valueList.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("주어진 숫자의 갯수가 6보다 작거나 큽니다.");
        }

        this.lottoNumbers = new LottoNumbers(valueList.subList(0, valueList.size()));
    }
}
