package lotto.domain;

import lotto.domain.validator.LottoValidator;
import lotto.utils.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WonNumbers {

    private final List<WonNumber> wonNumbers;

    public WonNumbers(String wonNormalNumbersValue, String wonBonusNumberValue) {

        validateInputs(wonNormalNumbersValue, wonBonusNumberValue);

        List<Integer> wonNormalNumbers = LottoParser.parse(wonNormalNumbersValue);
        LottoValidator.validateNumbers(wonNormalNumbers);

        int wonBonusNumber = Integer.parseInt(wonBonusNumberValue);
        LottoValidator.validateNumber(wonBonusNumber);

        this.wonNumbers = createWonNumbers(wonNormalNumbers, wonBonusNumber);
    }

    private List<WonNumber> createWonNumbers(List<Integer> wonNormalNumbers, int wonBonusNumber) {

        return Stream.of(buildWonNormalNumbers(wonNormalNumbers),
                         buildWonBonusNumber(wonBonusNumber))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<WonNumber> buildWonNormalNumbers(List<Integer> wonNormalNumbers) {

        return wonNormalNumbers.stream().map(WonNumber::ofNormalNumber).collect(Collectors.toList());
    }

    private List<WonNumber> buildWonBonusNumber(int wonBonusNumber) {

        return Collections.singletonList(WonNumber.ofBonusNumber(wonBonusNumber));
    }

    private void validateInputs(String wonNormalNumbersValue, String wonBonusNumbers) {

        if (StringUtils.isBlank(wonNormalNumbersValue) || StringUtils.isBlank(wonBonusNumbers)) {
            throw new IllegalArgumentException("입력받은 우승번호가 유효하지 않습니다.");
        }
    }

    public List<WonNumber> getNormalNumbers() {

        return wonNumbers.stream()
                .filter(wonNumber -> !wonNumber.isBonusNumber())
                .collect(Collectors.toList());
    }

    public WonNumber getBonusNumber() {

        return wonNumbers.stream()
                .filter(WonNumber::isBonusNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("보너스번호가 존재하지 않습니다."));
    }
}
