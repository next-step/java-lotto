package step02.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoBallCollections {
    private final List<LottoBall> numbersCount;

    private LottoBallCollections(List<LottoBall> lottoBalls) {
        this.numbersCount = lottoBalls;
    }

    public static LottoBallCollections of(List<LottoBall> lottoBalls) {
        return new LottoBallCollections(lottoBalls);
    }

    public List<LottoBall> filter(int from, int to) {
        return numbersCount.stream()
                .filter(numberCount -> numberCount.filter(from, to))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBallCollections that = (LottoBallCollections) o;
        return Objects.equals(numbersCount, that.numbersCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbersCount);
    }
}
