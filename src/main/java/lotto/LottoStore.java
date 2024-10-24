package lotto;

public class LottoStore {
    public void buy(int fee) {
        if (fee % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요");
        }
    }
}
