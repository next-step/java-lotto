package lotto.model;

import common.model.Number;
import lotto.application.Constant;

import java.util.Arrays;
import java.util.List;
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
                .map(LottoNumberFactory::manualCreateNumber)
                .collect(Collectors.toList());
    }

    private void lengthValidation(String[] numbers) {
        if (numbers.length != Constant.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(Constant.EXCEPTION_MESSAGE_LENGTH_VALIDATION);
        }
    }

    private void duplicateValidation(String[] numbers) {
        if (Arrays.stream(numbers).collect(Collectors.toSet()).size() != Constant.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(Constant.EXCEPTION_MESSAGE_DUPLICATE_VALIDATION);
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
