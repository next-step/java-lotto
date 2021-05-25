package study.ascii92der.lotto.step3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> lottoNumberArray) {
        lottoNumbers = new ArrayList<>();

        validDuplicateNumber(lottoNumberArray);

        for (Integer value : lottoNumberArray) {
            lottoNumbers.add(new LottoNumber(value));
        }
    }

    public List<LottoNumber> generateNumber() {

        return lottoNumbers;
    }

    private void validDuplicateNumber(List<Integer> lottoNumberArray) {
        Set<Integer> lottoNumberSet = new HashSet<>();
        lottoNumberSet.addAll(lottoNumberArray);
        if (lottoNumberSet.size() != lottoNumberArray.size()) {
            throw new IllegalArgumentException("This Numbers has duplicate number");
        }
    }
}
