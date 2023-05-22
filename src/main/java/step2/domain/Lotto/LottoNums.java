package step2.domain.Lotto;

import step2.domain.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoNums {

    private final List<LottoNum> lottoNums = new ArrayList<>(6);

    public LottoNums(Builder builder) {
        this.lottoNums.addAll(builder.lottoNums);
    }

    public String getNums() {
        return Arrays.toString(lottoNums
                .stream()
                .mapToInt(LottoNum::getValue)
                .sorted()
                .toArray());
    }

    public int compareTo(List<LottoNum> lottoNumList) {
        return (int) lottoNumList.stream()
                .filter(this.lottoNums::contains)
                .count();
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

        private final List<LottoNum> lottoNums = new ArrayList<>();

        public Builder lottoNum(LottoNum firstNum) {
            lottoNums.add(firstNum);
            return this;
        }

        private void validateLottoNums() {
            if (lottoNums.size() == Constant.LOTTO_NUM_SIZE) {
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
