package lottogame.domain;

import lottogame.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class LottoGame {

    public static final int LOTTO_GAME_SIZE = 6;

    private final List<LottoNumber> gameNumbers;

    public LottoGame(String[] lottoNumbers) {
        if (isInvalid(lottoNumbers)) {
            throw new IllegalArgumentException();
        }

        gameNumbers = getGameNumbers(lottoNumbers);
    }

    public LottoGame(List<Integer> lottoNumbers) {
        if (isInvalid(lottoNumbers)) {
            throw new IllegalArgumentException();
        }

        gameNumbers = getGameNumbers(lottoNumbers);
    }

    static boolean isInvalid(String[] lottoNumbers) {
        return lottoNumbers == null || lottoNumbers.length != LOTTO_GAME_SIZE;
    }

    static boolean isInvalid(List<Integer> lottoNumbers) {
        return lottoNumbers == null || lottoNumbers.size() != LOTTO_GAME_SIZE;
    }

    static List<LottoNumber> getGameNumbers(String[] strings) {
        return getGameNumbers(
                Optional.ofNullable(strings)
                        .map(StringUtils::parseIntegerList)
                        .orElse(Collections.emptyList())
        );
    }

    static List<LottoNumber> getGameNumbers(List<Integer> integers) {
        return Optional.ofNullable(integers)
                .orElse(Collections.emptyList())
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    List<LottoNumber> getGameNumbers() {
        return gameNumbers;
    }

    public int getMatchedCount(LottoGame targetNumbers) {
        return (int) Optional.ofNullable(targetNumbers)
                .map(LottoGame::getGameNumbers)
                .orElse(Collections.emptyList())
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