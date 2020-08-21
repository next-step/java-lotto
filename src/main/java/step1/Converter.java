package step1;

import org.apache.commons.lang3.StringUtils;

public interface Converter {
    default int toInt(String inputNumbers) {
        if (!StringUtils.isNumeric(inputNumbers)) {
            throw new RuntimeException("숫자가 아닙니다.");
        }
        return Integer.parseInt(inputNumbers);
    }

    boolean supports();

    CalculationNumber convertInputCalculationNumbers();
}
