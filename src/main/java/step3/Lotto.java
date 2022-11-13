package step3;

import java.util.Set;

public class Lotto {
    private static final int LOTTO_START = 1;
    private static final int LOTTO_END = 45;
    private static final int LOTTO_SIZE = 6;

    protected Set<Integer> lotto;

    public Lotto(Set<Integer> lotto) {
        validate(lotto);
        this.lotto = lotto;
    }

    public int count(Lotto other) {
        return (int) other.lotto.stream()
                .filter(this::isExist)
                .count();
    }

    public boolean isExist(Integer lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    private void validate(Set<Integer> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException("중복되지 않는 숫자 " + LOTTO_SIZE + "개를 입력해주세요.");
        }
        for (Integer integer : lotto) {
            checkLottoRange(integer);
        }
    }

    protected void checkLottoRange(Integer integer) {
        if (integer < 1 || integer > 45) {
            throw new IllegalArgumentException(LOTTO_START + " ~ " + LOTTO_END + " 사이의 수만 입력해주세요");
        }
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
