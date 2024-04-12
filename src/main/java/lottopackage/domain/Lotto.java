package lottopackage.domain;

import java.util.*;

public class Lotto {

    private final static int PRICE = 1000;
    private final static int LOTTO_SIZE = 6;

    private final Set<LottoBall> lotto = new HashSet<>();

    public Lotto() {
        while (lotto.size() != LOTTO_SIZE) {
            this.lotto.add(new LottoBall());
        }
    }

    public Lotto(Set<Integer> lotto) {
        isLottoValid(lotto);
        Iterator<Integer> iteratorLotto = lotto.iterator();
        while (iteratorLotto.hasNext()) {
            this.lotto.add(new LottoBall(iteratorLotto.next()));
        }
    }

    public Set<LottoBall> getLotto() {
        return lotto;
    }

    public static int purchaseLotto(int purchaseAmount) {
        if (purchaseAmount < PRICE) {
            throw new IllegalArgumentException("최소 주문 금액(=로또 한 장 금액)은 " + PRICE + "원 입니다.");
        }
        return (int) purchaseAmount / PRICE;
    }

    public static void isLottoValid(Set<?> lotto) {
        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 숫자는 6개여야 합니다.");
        }
    }

    public Prize checkPrize(Set<LottoBall> winningNumber, LottoBall bonusBall) {
        isLottoValid(winningNumber);
        return Prize.checkPrize(lotto, winningNumber, bonusBall);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto that = (Lotto) o;
        return Objects.equals(lotto, that.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    @Override
    public String toString() {
        String lotto = "[";

        Iterator<LottoBall> iteratorLotto = this.lotto.iterator();
        for (int i = 0; i < LOTTO_SIZE; i++) {
            String delimiter = (i == (LOTTO_SIZE - 1)) ? "" : ", ";
            lotto += (iteratorLotto.next() + delimiter);
        }

        lotto += "]";

        return lotto;
    }
}

