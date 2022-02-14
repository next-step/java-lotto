package lotto.domain;

import java.util.List;

public class LottoNumber {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;

        validateRange();
    }

    public static LottoNumber from(int lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    public boolean isInList(List<Integer> list) {
        return list.contains(lottoNumber);
    }

    public boolean isInLottoNumberList(List<LottoNumber> list) {
        return list.stream()
            .filter(x -> x.getLottoNumber() == lottoNumber)
            .count() > 0;
    }

    public boolean isEqualTo(LottoNumber number) {
        return number.getLottoNumber() == lottoNumber;
    }

    private void validateRange() {
        if (!isInRange()) {
            throw new RuntimeException("[ERROR] 로또 숫자의 범위는 1이상 45이하입니다.");
        }
    }

    private boolean isInRange() {
        return LOTTO_MIN_NUMBER <= lottoNumber && lottoNumber <= LOTTO_MAX_NUMBER;
    }
}
