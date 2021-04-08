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

    public static LottoBalls of(Integer... lottoBalls) {
        return LottoBalls.of(Arrays.asList(lottoBalls));
    }

    public static LottoBalls createWinningLottoBalls(List<Integer> lottoBallList) {
        validateSize(lottoBallList);
        return new LottoBalls(lottoBallList.stream()
                .map(LottoBall::new)
                .collect(Collectors.toList()));
    }

    public static LottoBalls of(List<Integer> lottoBallList) {
        validateSize(lottoBallList);
        return new LottoBalls(lottoBallList.stream()
                .map(LottoBall::valueOf)
                .collect(Collectors.toList()));
    }

    private static void validateSize(List<Integer> lottoBallList) {
        if (lottoBallList.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_MESSAGE);
        }
    }

    public int size() {
        return lottoBalls.size();
    }

    public int count(LottoBalls winningLottoBalls) {
        int lottoCount = 0;
        for (LottoBall winningLottoBall : winningLottoBalls.lottoBalls) {
            lottoCount += check(winningLottoBall);
        }
        return lottoCount;
    }

    private int check(LottoBall winningLottoBall) {
        int count = 0;
        if (lottoBalls.contains(winningLottoBall)) {
            count++;
        }
        return count;
    }

    public List<LottoBall> getSortedLottoBalls() {
        List<LottoBall> sortedLottoBalls = new ArrayList<>(lottoBalls);
        return Collections.unmodifiableList(sortedLottoBalls.stream().sorted().collect(Collectors.toList()));
    }
}
