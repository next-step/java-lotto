package step03.domain;

import exception.DuplicatedLottoNumberException;
import exception.InValidSizeOfLottoException;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final SortedSet<LottoBall> lotto;

    private Lotto (List<LottoBall> lottoBalls) {
        validate(lottoBalls);
        this.lotto = new TreeSet(lottoBalls);
    }

    public static Lotto of(List<LottoBall> lottoBalls) {
        return new Lotto(lottoBalls);
    }

    public static Lotto intOf(List<Integer> lottoBalls) {
        return of(
                lottoBalls.stream()
                        .map(number -> LottoBall.valueOf(number))
                        .collect(Collectors.toList())
        );
    }

    public int matchCount(Lotto targetLotto) {
        SortedSet<LottoBall> temp = new TreeSet<>(targetLotto.lotto);
        temp.retainAll(lotto);
        return temp.size();
    }

    private static void validate(List<LottoBall> lottoBalls) {
        validateUnique(lottoBalls);
        validateSize(lottoBalls);
    }

    private static void validateUnique(List<LottoBall> lottoBalls) {
        if (lottoBalls.size() != new HashSet<>(lottoBalls).size()) {
            throw new DuplicatedLottoNumberException();
        };
    }

    private static void validateSize(List<LottoBall> lottoBalls) {
        if (lottoBalls.size() != LOTTO_NUMBER_COUNT) {
            throw new InValidSizeOfLottoException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    public boolean isContaining(LottoBall lottoBall) {
        return lotto.contains(lottoBall);
    }
}
