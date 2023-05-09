package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNums {

    private final List<LottoNum> lottoNums;

    public LottoNums(Builder builder) {
        this.lottoNums = builder.lottoNums;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNums lottoNums1 = (LottoNums) o;

        return lottoNums.equals(lottoNums1.lottoNums);
    }

    @Override
    public int hashCode() {
        return lottoNums.hashCode();
    }

    public static class Builder {
        private static final int LOTTO_NUM_SIZE = 6;

        private final List<LottoNum> lottoNums = new ArrayList<>();

        public Builder lottoNum(LottoNum firstNum) {
            lottoNums.add(firstNum);
            return this;
        }

        private void validateLottoNums() {
            if (lottoNums.size() == LOTTO_NUM_SIZE) {
                return;
            }
            throw new IllegalArgumentException("로또 번호를 6자까지 입력해주세요.");
        }

        public LottoNums build() {
            validateLottoNums();
            return new LottoNums(this);
        }
    }
}
