package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.exception.Message.SIZE_MESSAGE;

public class LottoBalls {

    private static final int LOTTO_SIZE = 6;
    private final Set<LottoBall> lottoBalls;

    public LottoBalls(List<LottoBall> lottoBalls) {
        this.lottoBalls = new HashSet<>(lottoBalls);
    }

    public static LottoBalls createLottoBalls(Integer... lottoBalls) {
        return LottoBalls.createLottoBalls(Arrays.stream(lottoBalls).collect(Collectors.toSet()));
    }

    public static LottoBalls createLottoBalls(Set<Integer> lottoBallList) {
        validate(lottoBallList);
        return new LottoBalls(lottoBallList.stream()
                .map(LottoBall::valueOf)
                .collect(Collectors.toList()));
    }

    private static void validate(Set<Integer> lottoBallList) {
        if (lottoBallList.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_MESSAGE);
        }
//        if (lottoBallList.stream().distinct().count() != LOTTO_SIZE) {
//            throw new IllegalArgumentException(DUPLICATION_MESSAGE);
//        }
    }

    public int count(LottoBalls winningLottoBalls) {
        return (int) lottoBalls.stream()
                .filter(winningLottoBalls.lottoBalls::contains).count();
    }

    public boolean checkBonus(LottoBall bonusBall) {
        return lottoBalls.contains(bonusBall);
    }

    public List<LottoBall> getSortedLottoBalls() {
        List<LottoBall> sortedLottoBalls = new ArrayList<>(lottoBalls);
        return Collections.unmodifiableList(sortedLottoBalls.stream().sorted().collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBalls that = (LottoBalls) o;
        return Objects.equals(lottoBalls, that.lottoBalls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoBalls);
    }
}
