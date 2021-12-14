package step2.domain;

import step2.exception.LottoException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int NUMBER_OF_LOTTONUMBERS = 6;

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != NUMBER_OF_LOTTONUMBERS) {
            throw new LottoException("로또 번호는 6개여야 합니다.");
        }
    }

    public static Lotto from(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static Lotto from(Integer... numbers) {
        List<LottoNumber> lottoNumberList = Arrays.stream(numbers)
                .map(LottoNumber::from)
                .collect(Collectors.toList());
        return new Lotto(lottoNumberList);
    }

    public int numberOfMatching(LottoWinningNumbers lottoWinningNumbers) {
        int numberOfMatching = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            numberOfMatching += lottoWinningNumbers.numberContain(lottoNumber);
        }
        return numberOfMatching;
    }

    public int size() {
        return lottoNumbers.size();
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

}
