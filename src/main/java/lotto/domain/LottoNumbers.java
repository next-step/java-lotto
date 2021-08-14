package lotto.domain;

import lotto.common.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(NumberGenerator numberGenerator) {
        this.lottoNumbers = numberGenerator.generateNumber();
    }

    public boolean contains(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public long countMatches(LottoNumbers otherLottoNumbers) {
        int count = 0;
        for (int i = 0; i < lottoNumbers.size(); i++) {
            for (int j = 0; j < otherLottoNumbers.lottoNumbers.size(); j++) {
                if (lottoNumbers.get(i).getNumber() == otherLottoNumbers.lottoNumbers.get(j).getNumber()) {
                    count ++;
                }
            }
        }
        return count;
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            numbers.add(lottoNumber.getNumber());
        }
        return numbers;
    }
}
