package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixedGenerator implements LottoNumberGenerator {
    private final static int MIN = 0;
    private final static int MAX = 6;
    private final static String DEFAULT_REGEX = ",";

    private final List<LottoNumber> referenceNumbers;

    public FixedGenerator(String manualLotto) {
        String[] manualLottoNumbers = manualLotto.split(DEFAULT_REGEX);
        this.referenceNumbers = Arrays.stream(manualLottoNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<LottoNumber> extractLottoNumber() {
        return referenceNumbers.subList(MIN, MAX)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
