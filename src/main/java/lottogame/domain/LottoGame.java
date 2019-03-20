package lottogame.domain;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class LottoGame {

    public static final int LOTTO_GAME_SIZE = 6;

    private final List<LottoNumber> gameNumbers;

    public LottoGame(List<Integer> lottoNumbers) {
        if (isInvalid(lottoNumbers)) {
            throw new IllegalArgumentException();
        }

        gameNumbers = getGameNumbers(lottoNumbers);
    }

    private boolean isInvalid(List<Integer> lottoNumbers) {
        return lottoNumbers == null || lottoNumbers.size() != LOTTO_GAME_SIZE;
    }

    private List<LottoNumber> getGameNumbers(List<Integer> numbers) {
        return numbers.stream()
                        .map(LottoNumber::new)
                        .collect(Collectors.toList());
    }

    List<LottoNumber> getGameNumbers() {
        return gameNumbers;
    }

    public int getMatchedCount(LottoGame targetNumbers) {

        if( targetNumbers == null ||
            targetNumbers.getGameNumbers() == null ||
            targetNumbers.getGameNumbers().size() <= 0 ) {
            return 0;
        }

        return (int)targetNumbers.getGameNumbers()
                                 .stream()
                                 .filter(this::contains)
                                 .count();
    }

    public boolean contains(LottoNumber targetNumber) {
        return Optional.ofNullable(targetNumber)
                .filter(gameNumbers::contains)
                .isPresent();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGame that = (LottoGame) o;
        return gameNumbers.equals(that.gameNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameNumbers);
    }

    @Override
    public String toString() {
        return String.valueOf(gameNumbers);
    }
}