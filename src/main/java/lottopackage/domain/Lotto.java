package lottopackage.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    /* Variables */
    private final static int PRICE = 1000;
    public static List<Integer> lotteryBalls = new ArrayList<>(
            Arrays.stream(IntStream.rangeClosed(1, 45).toArray()).boxed().collect(Collectors.toList()));
    List<Integer> lotto;


    /* Constructor */
    public Lotto() {
        Collections.shuffle(lotteryBalls);
        lotto = new ArrayList<>(lotteryBalls.subList(0, 6));
    }

    public Lotto(List<Integer> lottoNumber) {
        isLottoNumberValid(lottoNumber);
        this.lotto = lottoNumber;
    }

    /* Getter */
    public static List<Integer> getLotteryBalls() {
        return lotteryBalls;
    }
    public List<Integer> getLotto() {
        return lotto;
    }

    /* Method */
    public static int purchaseLotto(int purchaseAmount) {
        if (purchaseAmount < PRICE) {
            throw new IllegalArgumentException("최소 주문 금액(=로또 한 장 금액)은 " + PRICE + "원 입니다.");
        }
        return (int) purchaseAmount/PRICE;
    }

    public static void isLottoNumberValid(List<Integer> lottoNumber) {
        if (lottoNumber.size() != 6) {
            throw new IllegalArgumentException("로또 숫자는 6개여야 합니다.");
        }
        if (!lotteryBalls.containsAll(lottoNumber)) {
            throw new IllegalArgumentException("로또 숫자는 1~45 안에 있어야 합니다.");
        }
    }

    public Prize isPrize(List<Integer> winningNumber) {
        isLottoNumberValid(winningNumber);
        return Prize.isPrize(lotto, winningNumber);
    }
}

