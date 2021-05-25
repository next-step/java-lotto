package lotto.domain;

import lotto.util.TextParser;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoManualGenerator implements LottoGenerator {
    private static final String DELIMITER = ",";
    private List<String> lottos;

    public LottoManualGenerator(List<String> manualLottos) {
        this.lottos = manualLottos;
    }

    @Override
    public List<Lotto> generateLottos() {
        return lottos.stream()
                .map(v -> getLottoNumbers(v))
                .map(v -> new Lotto(v))
                .collect(toList());
    }

    private static List<LottoNumber> getLottoNumbers(String text) {
        return Stream.of(text.split(DELIMITER))
                .map(String::trim)
                .map(TextParser::parseToInt)
                .map(LottoNumber::of)
                .collect(toList());
    }
}
