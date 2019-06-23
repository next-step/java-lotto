package lotto.domain;

import lotto.utils.LottoNumberValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WonNumbers {

    private static final String DELIMITER = ",";

    private final List<Integer> wonNormalNumbers;
    private final int wonBonusNumbers;

    public WonNumbers(String wonNormalNumbersValue, String wonBonusNumbers) {

        if (wonNormalNumbersValue == null || wonNormalNumbersValue.isEmpty()) {
            throw new IllegalArgumentException("입력받은 우승번호가 유효하지 않습니다.");
        }

        List<Integer> wonNormalNumbers = parse(wonNormalNumbersValue);
        LottoNumberValidator.validate(wonNormalNumbers);
        // TODO
        this.wonNormalNumbers = wonNormalNumbers;
        this.wonBonusNumbers = Integer.parseInt(wonBonusNumbers);
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

    public int getWonBonusNumbers() {

        return wonBonusNumbers;
    }
}
