package lottogame.domain;

import lottogame.validator.LottoNumberPackageValidator;
import lottogame.validator.Validatable;
import spark.utils.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

import static lottogame.view.ConsoleInputView.NUMBER_DELIMITER;

/**
 * 로또 1게임
 */
public class LottoNumberPackage {

    public static final int LOTTO_GAME_SIZE = 6;

    private final Set<LottoNumber> numbers;
    private final Validatable<Set<LottoNumber>> validator = new LottoNumberPackageValidator();

    public LottoNumberPackage(InputLine inputLine) {
        this(getNumbers(inputLine.getLine().split(NUMBER_DELIMITER)));
    }

    public LottoNumberPackage(Set<LottoNumber> numbers) {
        validator.validate(numbers);
        this.numbers = numbers;
    }

    private static Set<LottoNumber> getNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .map(LottoNumber::getInstance)
                    .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }

    public MatchStatus getMatchStatus(WinningInfo winningInfo) {
        return new MatchStatus(
            getMatchedCount(winningInfo.getNumbers()),
            isBonusNumberMatched(winningInfo.getBonusNumber())
        );
    }

    int getMatchedCount(LottoNumberPackage targetNumbers) {
        if(Objects.isNull(targetNumbers) ||
           CollectionUtils.isEmpty(targetNumbers.getNumbers())) {
            return Rank.MISS.getMatchedCount();
        }

        return (int)targetNumbers.getNumbers()
                                 .stream()
                                 .filter(this::contains)
                                 .count();
    }

    private boolean isBonusNumberMatched(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public boolean contains(LottoNumber targetNumber) {
        return Optional.ofNullable(targetNumber)
                .filter(numbers::contains)
                .isPresent();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumberPackage that = (LottoNumberPackage) o;
        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}