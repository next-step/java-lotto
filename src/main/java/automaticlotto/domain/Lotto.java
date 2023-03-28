package automaticlotto.domain;

import automaticlotto.automaticexception.ExceptionCommand;
import automaticlotto.automaticexception.InputValueException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new InputValueException(ExceptionCommand.NUMBER_WINNING_NUMBERS_EXCEPTION_MESSAGE);
        }
        if (lottoNumbers.size() != lottoNumbers.stream().map(LottoNumber::getLottoNumber).distinct().count()) {
            throw new InputValueException(ExceptionCommand.LOTTO_NUMBER_OVERLAP_EXCEPTION_MESSAGE);
        }
    }

    public static List<LottoNumber> createLotto() {
        List<LottoNumber> randomLottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            randomLottoNumbers.add(new LottoNumber((int) (Math.random() * 45 + 1)));
        }
        return randomLottoNumbers;
    }

    public static List<LottoNumber> sortLotto(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .sorted(Comparator.comparing(LottoNumber::getLottoNumber))
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

}
