package lottopackage.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBall {
    private final static Set<Integer> lotteryBalls = new HashSet<>(
            Arrays.stream(IntStream.rangeClosed(1, 45).toArray()).boxed().collect(Collectors.toSet()));
    private final int lottoBall;

    public LottoBall() {
        List<Integer> lotteryBallsForShuffle = new ArrayList<>(lotteryBalls);
        Collections.shuffle(lotteryBallsForShuffle);
        lottoBall = lotteryBallsForShuffle.get(0);
    }

    public LottoBall(int lottoBall) {
        isLottoBallValid(lottoBall);
        this.lottoBall = lottoBall;
    }

    public int getLottoBall() {
        return lottoBall;
    }

    public static Set<Integer> getLotteryBalls() {
        return lotteryBalls;
    }

    public static Set<Integer> setLottoBallToSetInteger(Set<LottoBall> setLottoBall) {
        Set<Integer> setInteger = new HashSet<>();
        Iterator<LottoBall> iteratorSetLottoBall = setLottoBall.iterator();
        while (iteratorSetLottoBall.hasNext()) {
            setInteger.add(iteratorSetLottoBall.next().getLottoBall());
        }
        return setInteger;
    }

    public static void isLottoBallValid(int lottoBall) {
        if (!lotteryBalls.contains(lottoBall)) {
            throw new IllegalArgumentException("로또 숫자는 1~45 안에 있어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBall lottoBall1 = (LottoBall) o;
        return lottoBall == lottoBall1.lottoBall;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoBall);
    }

    @Override
    public String toString() {
        return "" + lottoBall;
    }
}
