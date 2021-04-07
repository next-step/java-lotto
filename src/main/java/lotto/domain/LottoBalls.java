package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.domain.LottoGenerator.LOTTO_SIZE;

public class LottoBalls {
    private final Set<LottoBall> lottoBalls;

    public LottoBalls(LottoGenerator lottoGenerator) {
        this(lottoGenerator.createAutoLotto());
    }

    public LottoBalls(List<LottoBall> lottoBalls) {
        this.lottoBalls = new HashSet<>(lottoBalls);
    }

    public static LottoBalls of(Integer... lottoBalls) {
        return LottoBalls.of(Arrays.asList(lottoBalls));
    }

    public static LottoBalls of(List<Integer> lottoBallList) {
        validateSize(lottoBallList);
        return new LottoBalls(lottoBallList.stream()
                .mapToInt(lottoBall -> lottoBall)
                .mapToObj(LottoBall::valueOf)
                .collect(Collectors.toList()));
    }

    private static void validateSize(List<Integer> lottoBallList) {
        if (lottoBallList.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 숫자 개수가 6개가 아닙니다.");
        }
    }

    public int size() {
        return lottoBalls.size();
    }

}
