package lottopackage.domain;

import java.util.*;

public class Lotto {

    /* Variables */
    private final static int PRICE = 1000;
    private final static int LOTTO_SIZE = 6;

    private final Set<LottoBall> lotto = new HashSet<>();

    /* Constructor */
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

    /* Getter */
    public Set<LottoBall> getLotto() {
        return lotto;
    }

    /* Method */
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

    public Prize isPrize(Set<LottoBall> winningNumber) {
        isLottoValid(winningNumber);
        return Prize.isPrize(lotto, winningNumber);
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
}

