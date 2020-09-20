package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumber {
    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;

    private final int lottoNumber;
    private static final List<Integer> lottoSetting = new ArrayList<>();
    private static List<Integer> lottoNumbers = new ArrayList<>();

    static {
        for(int i = LOTTO_MIN; i <= LOTTO_MAX; i++) {
            lottoSetting.add(i);
        }
    }

    public LottoNumber(int lottoNumber) {
        validateLottoRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoRange(int lottoNumber) {
        if(lottoNumber < LOTTO_MIN || lottoNumber > LOTTO_MAX) {
            throw new IllegalArgumentException("로또의 범위를 벗어났습니다.");
        }
    }

    public static List<Integer> generateLottoNumber() {
        lottoNumbers.clear();
        Collections.shuffle(lottoSetting);
        for(int i = 0; i < Lotto.LOTTO_DIGIT; i++){
            lottoNumbers.add(lottoSetting.get(i));
        }
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber number = (LottoNumber) o;
        return lottoNumber == number.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return Integer.toString(lottoNumber);
    }
}
