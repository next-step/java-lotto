package lotto.model;

import common.model.Number;

import java.util.*;
import java.util.stream.Collectors;

public class LottoWinner {

    private final List<LottoNumber> winnerNumbers;

    public LottoWinner(String winnerNumbers) {
        this.winnerNumbers = convert(winnerNumbers);
    }

    private List<LottoNumber> convert(String numbers) {
        String[] splitNumbers = numbers.split(", ");

        duplicateValidation(splitNumbers);
        lengthValidation(splitNumbers);

        return Arrays.stream(splitNumbers)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void lengthValidation(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("당첨 번호가 6개가 아닙니다.");
        }
    }

    private void duplicateValidation(String[] numbers) {
        if (Arrays.stream(numbers).collect(Collectors.toSet()).size() != 6) {
            throw new IllegalArgumentException("중복되는 당첨 번호가 있습니다.");
        }
    }

    public void match(LottoNumbers lottoNumbers) {
        Number matchCount = new Number();
        for (LottoNumber lottoNumber : lottoNumbers.getLottoNumbers()) {
            match(lottoNumber, matchCount);
        }
        lottoNumbers.matchRank(matchCount);
    }

    public void match(LottoNumber lottoNumber, Number matchCount) {
        if (contains(lottoNumber)) {
            matchCount.plus();
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.winnerNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> getWinnerNumbers() {
        return winnerNumbers;
    }
}
