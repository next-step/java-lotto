package step3;

import java.util.Set;
import java.util.TreeSet;

public class Lotto {
    private static final int LOTTO_START = 1;
    private static final int LOTTO_END = 45;

    private Set<Integer> lotto;

    public Lotto(Set<Integer> lotto) {
        this.lotto = lotto;
    }

    public Lotto(String[] inputs) {
        this(makeLotto(inputs));
    }

    private static Set<Integer> makeLotto(String[] inputs) {
        Set<Integer> lotto = new TreeSet<>();
        for (String input : inputs) {
            int ball = Integer.parseInt(input);
            checkRange(ball);
            lotto.add(ball);
        }
        checkSizeOfLotto(lotto);
        return lotto;
    }

    private static void checkRange(int ball) {
        if (ball < LOTTO_START || ball > LOTTO_END) {
            throw new IllegalArgumentException(LOTTO_START + " ~ " + LOTTO_END + " 사이의 수만 입력해주세요");
        }
    }

    private static void checkSizeOfLotto(Set<Integer> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException(LOTTO_START + " ~ " + LOTTO_END + " 중복되지 않는 수를 입력해주세요");
        }
    }

    public boolean checkBonus(int bonus) {
        return lotto.contains(bonus);
    }

    public int count(Lotto other) {
        return (int) other.getLotto().stream()
                .filter(this::isExist)
                .count();
    }

    public boolean isExist(Integer lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public Set<Integer> getLotto() {
        return lotto;
    }
}
