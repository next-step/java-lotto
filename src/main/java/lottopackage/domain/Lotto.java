package lottopackage.domain;

import java.util.*;

public class Lotto {

    private final static int PRICE = 1000;
    private final static int LOTTO_SIZE = 6;
    private final Set<LottoBall> LOTTO = new HashSet<>();

    public Lotto() {
        while (LOTTO.size() != LOTTO_SIZE) {
            this.LOTTO.add(new LottoBall());
        }
    }

    public Lotto(Set<Integer> lotto) {
        isLottoValid(lotto);
        Iterator<Integer> iteratorLotto = lotto.iterator();
        while (iteratorLotto.hasNext()) {
            this.LOTTO.add(new LottoBall(iteratorLotto.next()));
        }
    }

    /* 강의에서의 주생성자, 부생성자 내용
    public Lotto() {
        while (lotto.size() != LOTTO_SIZE) {
            this.lotto.add(new LottoBall());
        }
    }

    public Lotto(LottoBall... balls) {
        this(Arrays.asList(balls));
    }

    public Lotto(List<LottoBall> balls) {
        this(new HashSet<>(balls));
    }

    public Lotto(Set<LottoBall> balls) {
        isLottoValid(balls);
        this.lotto = balls;
    }
    */

    public Set<LottoBall> getLotto() {
        return LOTTO;
    }

    public static int getLottoSize() {
        return LOTTO_SIZE;
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

    public Prize checkPrize(WinningNumber winningNumber) {
        return Prize.checkPrize(LOTTO, winningNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto that = (Lotto) o;
        return Objects.equals(LOTTO, that.LOTTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LOTTO);
    }

    @Override
    public String toString() {
        String lotto = "[";

        Iterator<LottoBall> iteratorLotto = this.LOTTO.iterator();
        for (int i = 0; i < LOTTO_SIZE; i++) {
            String delimiter = (i == (LOTTO_SIZE - 1)) ? "" : ", ";
            lotto += (iteratorLotto.next() + delimiter);
        }

        lotto += "]";

        return lotto;
    }
}

