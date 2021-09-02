package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.constraint.Constraint;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers(final List<Integer> integerNumbers) {
        for (Integer number : integerNumbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        validSizeCheck(lottoNumbers);
        validDuplicateCheck(lottoNumbers);
    }

    private void validSizeCheck(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != Constraint.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또는 6자리가 되어야 합니다.");
        }
    }

    private void validDuplicateCheck(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> numbers = new HashSet<>(lottoNumbers);
        if (numbers.size() != Constraint.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 수가 있습니다.");
        }
    }

    public int getMatchCount(LottoNumbers winningNumbers) {
        int matchCnt = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                matchCnt++;
            }
        }
        return matchCnt;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }


    public String makeLottoNumbersStringList() {
        return "["
            + lottoNumbers.stream().map(Object::toString).collect(Collectors.joining(", "))
            + "]";
    }
}
