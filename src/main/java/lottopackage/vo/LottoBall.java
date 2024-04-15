package lottopackage.vo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBall {
    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = 45;

    private final static Set<Integer> lotteryBalls = new HashSet<>(
            Arrays.stream(IntStream.rangeClosed(MIN_VALUE, MAX_VALUE).toArray())
                    .boxed()
                    .collect(Collectors.toSet()));
    private final int lottoBall;

    public LottoBall() {
        this(autoLottoBall());
    }

    private static int autoLottoBall() {
        List<Integer> lotteryBallsForShuffle = new ArrayList<>(lotteryBalls);
        Collections.shuffle(lotteryBallsForShuffle);
        return lotteryBallsForShuffle.get(0);
    }

    public LottoBall(String string) {
        this(Integer.parseInt(string));
    }

    public LottoBall(int lottoBall) {
        if (!lotteryBalls.contains(lottoBall)) {
            throw new IllegalArgumentException("로또 숫자는 1~45 안에 있어야 합니다.");
        }
        this.lottoBall = lottoBall;
    }

    public int getLottoBall() {
        return lottoBall;
    }

    public static Set<Integer> setLottoBallToSetInteger(Set<LottoBall> setLottoBall) {
        Set<Integer> setInteger = new HashSet<>();
        Iterator<LottoBall> iteratorSetLottoBall = setLottoBall.iterator();
        while (iteratorSetLottoBall.hasNext()) {
            setInteger.add(iteratorSetLottoBall.next().getLottoBall());
        }
        return setInteger;
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
