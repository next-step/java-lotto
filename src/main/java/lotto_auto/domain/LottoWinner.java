package lotto_auto.domain;

import lotto_auto.util.LottoValidate;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoWinner {
    private final Set<LottoNumber> winnerNumbers;

    public LottoWinner(String input) {
        this.winnerNumbers = LottoValidate.validateLottoNumbers(parseLottoNumbers(input));
    }

    public Set<LottoNumber> parseLottoNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(this::parseWinnerLottoNumber)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    private Integer parseWinnerLottoNumber(String input) {
        return Integer.parseInt(input.trim());
    }

    public Set<LottoNumber> getWinnerNumbers() {
        return winnerNumbers;
    }

}
