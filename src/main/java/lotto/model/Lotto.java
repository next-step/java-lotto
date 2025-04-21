package lotto.model;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    protected Set<LottoNumber> numbers;
    private LottoPrize lottoPrize;

    public Lotto(Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public Lotto(String numbers) {
        this.numbers = Arrays.stream(numbers.split(","))
                             .map(String::trim)
                             .map(Integer::parseInt)
                             .map(LottoNumber::new)
                             .collect(Collectors.toSet());
    }

    protected boolean containsNumber(LottoNumber number) {
        return numbers.contains(number);
    }

    public void validate() {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("The number of Lotto numbers must be 6.");
        }
    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }

    public LottoPrize getLottoPrize() {
        return lottoPrize;
    }

    public void setLottoPrize(WinningLotto winningLotto) {
        long matched = winningLotto.getNumbers().stream()
                              .filter(numbers::contains)
                              .count();
        boolean isBonusNumber = numbers.contains(winningLotto.bonus) && matched == LottoPrize.SECOND.getMatchedCount();

        this.lottoPrize = LottoPrize.valueOf(matched, isBonusNumber);
    }

    @Override
    public String toString() {
        String result = numbers.stream()
                               .sorted()
                               .map(LottoNumber::toString)
                               .collect(Collectors.joining(", "));
        return String.format("[%s]", result);
    }
}
