package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private final List<Integer> lottoNumbers = new ArrayList<>();

    public LottoNumbers() {
        lottoNumbers.addAll(LottoNumberSelector.selectNumbers());
    }

    public String getNumberString() {
        List<String> numbers = new ArrayList<>();
        for (Integer lottoNumber : lottoNumbers) {
            numbers.add(lottoNumber.toString());
        }
        return "[" + String.join(", ", numbers) + "]";
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
