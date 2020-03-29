package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final List<Number> getneratedNumber;

    public LottoNumbers(List<Number> getneratedNumber) {
        this.getneratedNumber = shuffleNumbers(getneratedNumber);
    }

    private List<Number> shuffleNumbers(List<Number> generatedNumber) {
        Collections.shuffle(generatedNumber);
        return new ArrayList<>(generatedNumber);
    }

    public List<Number> getLottoNumbers() {
        return getneratedNumber.stream()
                .limit(6)
                .sorted()
                .collect(Collectors.toList());
    }
}
