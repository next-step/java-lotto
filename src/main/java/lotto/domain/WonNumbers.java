package lotto.domain;

import lotto.domain.validator.LottoNumberValidator;
import lotto.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WonNumbers {

    private static final String DELIMITER = ",";

    private final List<Integer> wonNormalNumbers;
    private final int wonBonusNumberValue;

    public WonNumbers(String wonNormalNumbersValue, String wonBonusNumberValue) {

        validateInputs(wonNormalNumbersValue, wonBonusNumberValue);

        List<Integer> wonNormalNumbers = parse(wonNormalNumbersValue);
        LottoNumberValidator.validate(wonNormalNumbers);
        this.wonNormalNumbers = wonNormalNumbers;

        int wonBonusNumber = Integer.parseInt(wonBonusNumberValue);
        LottoNumberValidator.validateNumber(wonBonusNumber);
        this.wonBonusNumberValue = wonBonusNumber;
    }

    private List<Integer> parse(String wonNumbersValue) {

        return Arrays.stream(wonNumbersValue.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getWonNormalNumbers() {

        return wonNormalNumbers;
    }

    public int getWonBonusNumberValue() {

        return wonBonusNumberValue;
    }

    private void validateInputs(String wonNormalNumbersValue, String wonBonusNumbers) {

        if (StringUtils.isBlank(wonNormalNumbersValue) || StringUtils.isBlank(wonBonusNumbers)) {
            throw new IllegalArgumentException("입력받은 우승번호가 유효하지 않습니다.");
        }
    }
}
