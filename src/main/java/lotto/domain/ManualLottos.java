package lotto.domain;

import lotto.StringParser;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottos {
    public static List<Lotto> createLottos(List<String> manualLottoNumbers) {
        return manualLottoNumbers.stream()
                .map(numbers -> Lotto.of(StringParser.getParseNumbers(numbers)))
                .collect(Collectors.toList());
    }
}
