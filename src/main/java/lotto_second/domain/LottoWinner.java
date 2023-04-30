package lotto_second.domain;

import lotto_second.util.LottoValidate;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoWinner {
    private final Set<LottoNumber> winnerNumbers;
    private final LottoNumber bonusNumber;

    public LottoWinner(String input, String bonusNumber) {
        this.winnerNumbers = LottoValidate.validateLottoNumbers(parseLottoNumbers(input));
        this.bonusNumber = new LottoNumber(parseWinnerLottoNumber(bonusNumber));
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

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

}
