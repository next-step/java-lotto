package step2.domain;

import step2.domain.util.LotteryGenerator;
import step2.domain.util.exception.LotteryFormatException;
import step2.strategy.LotteryStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lottery {
    private final List<Number> lottery;

    private Lottery(List<Number> randomNumbers) {
        if (randomNumbers.size() != LotteryGenerator.LOTTERY_SIZE) {
            throw new LotteryFormatException("복권 번호는 6자리 필수");
        }

        this.lottery = new ArrayList<>(randomNumbers);
    }

    public static Lottery createFromStrategy(LotteryStrategy strategy) {
        return new Lottery(strategy.getLotteryNumbers()
                .stream()
                .map(n -> Number.createFromInt(n))
                .collect(Collectors.toList()));
    }

    public static Lottery createFromList(List<Number> numbers) {
        return new Lottery(numbers);
    }

    public int getCorrectCount(Lottery winningNumbers) {
        return Long.valueOf(this.lottery.stream()
                .filter(n -> winningNumbers.getNumbers().stream()
                        .anyMatch(Predicate.isEqual(n)))
                .count()).intValue();
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(lottery);
    }

    public boolean isCorrectBonusNumber(Number bonusNumber) {
        return lottery.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottery lottery1 = (Lottery) o;
        return Objects.equals(lottery, lottery1.lottery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottery);
    }
}
