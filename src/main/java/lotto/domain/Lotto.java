package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Lotto {
    static final int LOTTO_NUMBER_SIZE = 6;
    static final String DELIMITER = "[ ,]+";

    void checkSizeOfLotto(List<LottoNumber> lottoNumbers) {
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
        checkSizeOfLotto(lottoNumbers.size());
        return lottoNumbers;
    }

    static void checkSizeOfLotto(int size) {
        //TODO: checkSzieOfLotto 가 리팩터링하다보니 2개가 됨. 파라미터가 다른 곳을 찾고 수정해야함.
        if (size != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또의 숫자는 6개입니다.");
        }
    }
}
