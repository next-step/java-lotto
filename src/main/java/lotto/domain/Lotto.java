package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Lotto {
    static final int LOTTO_NUMBER_SIZE = 6;
    static final String DELIMITER = "[ ,]+";


    static void checkSizeOfLotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개이어야 합니다.");
        }
    }

    void checkDuplicatedNumber(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumbersChecker = new HashSet<>(lottoNumbers);
        if (lottoNumbersChecker.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 로또번호가 있습니다.");
        }
    }

    public static List<LottoNumber> getLottoWithSplitting(String text) {
        String [] inputs = text.split(DELIMITER);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String input : inputs) {
            lottoNumbers.add(new LottoNumber(Validator.checkIsIntegerAndIsNegative(input)));
        }
        checkSizeOfLotto(lottoNumbers);
        return lottoNumbers;
    }

}
