package lotto.model;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static lotto.model.Lotto.NUMBER_COUNT;

public class RandomLottoNumberGenerating implements LottoNumberGeneratingStrategy {

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
