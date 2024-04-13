package lottopackage.domain;

import java.util.*;

public class Lotto {

    private final static int PRICE = 1000;
    private final static int LOTTO_SIZE = 6;
    private Set<LottoBall> lotto;

    public Lotto() {
        Set<LottoBall> lotto = new HashSet<>();
        while (lotto.size() != LOTTO_SIZE) {
            lotto.add(new LottoBall());
        }
        this.lotto = lotto;
    }

    public Lotto(Integer... numbers) {
        this(toLotto(numbers));
    }

    private static Set<LottoBall> toLotto(Integer... lottoBalls) {
        Set<LottoBall> lotto = new HashSet<>();
        for (Integer ball : lottoBalls) {
            lotto.add(new LottoBall(ball));
        }
        return lotto;
    }

    public Lotto(LottoBall... lottoBall) {
        this( new HashSet<>(Arrays.asList(lottoBall)) );
    }

    public Lotto(Set<LottoBall> lotto) {
        isLottoValid(lotto);
        this.lotto = lotto;
    }

    public Set<LottoBall> getLotto() {
        return lotto;
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

    public Prize checkPrize(WinningNumberAndBonusBall winningNumberAndBonusBall) {
        return Prize.checkPrize(lotto, winningNumberAndBonusBall);
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

