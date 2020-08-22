package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberRandomExtractor implements LottoNumberExtractor {

    private final static List<LottoNumber> allLottoNumbers;

    static {
        allLottoNumbers = new ArrayList<>();
        for (int i = LottoNumber.LOTTO_MIN; i <= LottoNumber.LOTTO_MAX; i++) {
            allLottoNumbers.add(new LottoNumber(i));
        }
    }

    @Override
    public List<LottoNumber> getNumbers(int size) {
        mixNumbers();
        return allLottoNumbers.stream()
                .limit(size)
                .sorted()
                .collect(Collectors.toList());
    }

    private void mixNumbers() {
        Collections.shuffle(allLottoNumbers);
    }
}
