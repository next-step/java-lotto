package lotto.model;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RandomLottoNumberGenerating implements LottoNumberGeneratingStrategy {
    private static final int NUMBER_COUNT = 6;

    @Override
    public List<LottoNumber> generateNumbers() {
        List<LottoNumber> allLottoNumbers = LottoNumber.getAllLottoNumbers();
        Collections.shuffle(allLottoNumbers);

        return allLottoNumbers.stream()
                .limit(NUMBER_COUNT)
                .sorted()
                .collect(toList());
    }
}
