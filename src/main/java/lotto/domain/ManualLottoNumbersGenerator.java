package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoNumbersGenerator {
    private final int manualCount;
    private final List<String> manualNumbers;

    public ManualLottoNumbersGenerator(int manualCount, List<String> manualNumbers) {
        this.manualCount = manualCount;
        this.manualNumbers = manualNumbers;
    }

    public List<LottoNumbers> generate() {
        return manualNumbers.stream()
                .map(LottoNumbers::of)
                .collect(Collectors.toList());
    }
}
