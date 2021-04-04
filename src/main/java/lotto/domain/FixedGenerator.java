package lotto.domain;

import lotto.constant.LottoConstant;
import lotto.constant.LottoError;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixedGenerator implements LottoNumberGenerator {
    private final static String DEFAULT_REGEX = ",";

    private final List<LottoNumber> referenceNumbers;

    public FixedGenerator(String manualLotto) {
        String[] manualLottoNumbers = manualLotto.split(DEFAULT_REGEX);
        if (manualLottoNumbers.length > LottoConstant.LOTTO_SIZE_MAX) {
            throw new IllegalArgumentException(LottoError.LOTTO_SIZE_OVER_EXCEPTION);
        }

        this.referenceNumbers = Arrays.stream(manualLottoNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<LottoNumber> extractLottoNumber() {
        return referenceNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
