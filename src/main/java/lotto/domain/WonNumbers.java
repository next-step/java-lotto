package lotto.domain;

import lotto.domain.validator.LottoNumberValidator;
import lotto.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WonNumbers {

    private static final String DELIMITER = ",";

    private final List<WonNumber> wonNumbers;

    public WonNumbers(String wonNormalNumbersValue, String wonBonusNumberValue) {

        validateInputs(wonNormalNumbersValue, wonBonusNumberValue);

        List<Integer> wonNormalNumbers = parse(wonNormalNumbersValue);
        LottoNumberValidator.validate(wonNormalNumbers);

        int wonBonusNumber = Integer.parseInt(wonBonusNumberValue);
        LottoNumberValidator.validateNumber(wonBonusNumber);

        this.wonNumbers = createWonNumbers(wonNormalNumbers, wonBonusNumber);
    }

    private List<WonNumber> createWonNumbers(List<Integer> wonNormalNumbers, int wonBonusNumber) {

        List<WonNumber> wonNumbers = wonNormalNumbers.stream()
                .map(WonNumber::ofNormalNumber)
                .collect(Collectors.toList());
        wonNumbers.add(WonNumber.ofBonusNumber(wonBonusNumber));

        return wonNumbers;
    }

    private List<Integer> parse(String wonNumbersValue) {

        return Arrays.stream(wonNumbersValue.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateInputs(String wonNormalNumbersValue, String wonBonusNumbers) {

        if (StringUtils.isBlank(wonNormalNumbersValue) || StringUtils.isBlank(wonBonusNumbers)) {
            throw new IllegalArgumentException("입력받은 우승번호가 유효하지 않습니다.");
        }
    }

    public List<WonNumber> getNormalNumbers() {

        return wonNumbers.stream().filter(wonNumber -> !wonNumber.isBonusNumber()).collect(Collectors.toList());
    }

    public List<WonNumber> getBonusNumbers() {

        return wonNumbers.stream().filter(WonNumber::isBonusNumber).collect(Collectors.toList());
    }
}
