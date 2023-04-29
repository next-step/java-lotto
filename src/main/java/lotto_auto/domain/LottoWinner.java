package lotto_auto.domain;

import lotto_auto.util.LottoValidate;

import java.util.HashSet;
import java.util.Set;

public class LottoWinner {
    private final Set<LottoNumber> winnerNumbers;

    public LottoWinner(String input) {
        this.winnerNumbers = LottoValidate.validateLottoNumbers(parseLottoNumbers(input));
    }

    public Set<LottoNumber> parseLottoNumbers(String input) {
        String[] splitNumbers = input.split(",");
        Set<LottoNumber> winnerNumbers = new HashSet<>();

        for (String number : splitNumbers) {
            winnerNumbers.add(new LottoNumber(parseWinnerLottoNumber(number)));
        }

        return winnerNumbers;
    }

    private static Integer parseWinnerLottoNumber(String input) {
        int number = 0;

        try {
            number = Integer.parseInt(input.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("올바르지 않은 당첨번호입니다");
        }

        return number;
    }

    public Set<LottoNumber> getWinnerNumbers() {
        return winnerNumbers;
    }

}
