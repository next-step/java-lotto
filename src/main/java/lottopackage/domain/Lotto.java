package lottopackage.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    /* Variables */
    private final static int PRICE = 1000;
    private final static Set<Integer> lotteryBalls = new HashSet<>(
            Arrays.stream(IntStream.rangeClosed(1, 45).toArray()).boxed().collect(Collectors.toSet()));
    private final Set<Integer> lotto;

    /* Constructor */
    public Lotto() {
        List<Integer> lotteryBallsForShuffle = new ArrayList<>(lotteryBalls);
        Collections.shuffle(lotteryBallsForShuffle);
        lotto = new HashSet<>(lotteryBallsForShuffle.subList(0, 6));
    }

    public Lotto(Set<Integer> lottoNumber) {
        isLottoValid(lottoNumber);
        this.lotto = lottoNumber;
    }

    /* Getter */
    public static Set<Integer> getLotteryBalls() {
        return lotteryBalls;
    }

    public Set<Integer> getLotto() {
        return lotto;
    }

    /* Method */
    public static int purchaseLotto(int purchaseAmount) {
        if (purchaseAmount < PRICE) {
            throw new IllegalArgumentException("최소 주문 금액(=로또 한 장 금액)은 " + PRICE + "원 입니다.");
        }
        return (int) purchaseAmount / PRICE;
    }

    public Prize isPrize(Set<Integer> winningNumber) {
        isLottoValid(winningNumber);
        return Prize.isPrize(lotto, winningNumber);
    }

    public static void isLottoValid(Set<Integer> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException("로또 숫자는 6개여야 합니다.");
        }
        for (int lottoNumber : lotto) {
            isLottoNumberValid(lottoNumber);
        }
    }

    public static void isLottoNumberValid(int lottoNumber) {
        if (!lotteryBalls.contains(lottoNumber)) {
            throw new IllegalArgumentException("로또 숫자는 1~45 안에 있어야 합니다.");
        }
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

