package lottopackage.domain;

import java.util.*;

public class Lotto {

    private final static int PRICE = 1000;
    private LottoBalls lotto;

    public Lotto() {
        this.lotto = new LottoBalls();
    }

    public Lotto(Integer... numbers) {
        this(toLottoBalls(numbers));
    }

    private static Set<LottoBall> toLottoBalls(Integer... lottoBalls) {
        Set<LottoBall> lotto = new HashSet<>();
        for (Integer ball : lottoBalls) {
            lotto.add(new LottoBall(ball));
        }
        return lotto;
    }

    public Lotto(LottoBall... lottoBall) {
        this( new HashSet<>(Arrays.asList(lottoBall)) );
    }

    public Lotto(Set<LottoBall> lottoBalls) {
        this(new LottoBalls(lottoBalls));
    }

    public Lotto(LottoBalls lottoBalls) {
        this.lotto = lottoBalls;
    }

    public LottoBalls getLotto() {
        return lotto;
    }

    public static int purchaseLotto(int purchaseAmount) {
        if (purchaseAmount < PRICE) {
            throw new IllegalArgumentException("최소 주문 금액(=로또 한 장 금액)은 " + PRICE + "원 입니다.");
        }
        return (int) purchaseAmount / PRICE;
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
        return lotto.toString();
    }
}

