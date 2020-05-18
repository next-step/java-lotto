package lotto.domain;

import java.util.Objects;

public class LottoNum {

    private final int num;

    public LottoNum(int num){
        validate(num);
        this.num = num;
    }

    private void validate(int num) {
        if(num <= 0 || num >= 46){
            throw new IllegalArgumentException("lotto num is 1 to 45");
        }
    }

    int getVal() {
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNum lottoNum = (LottoNum) o;
        return num == lottoNum.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}

