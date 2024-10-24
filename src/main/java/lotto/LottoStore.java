package lotto;

public class LottoStore {
    public void buy(int fee) {
        if (isNotThousandUnit(fee)) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요");
        }
    }

    private boolean isNotThousandUnit(int fee) {
        return fee % 1000 != 0;
    }
}
