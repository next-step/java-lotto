package step2.domain.impl;

import step2.domain.NumberProvider;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManualProvider implements NumberProvider {

    private static final String DELIMITER = ", ";

    private final Set<String> values;

    public ManualProvider(String manualNumber) {
        validateNullAndEmpty(manualNumber);
        this.values = new HashSet<>(List.of(manualNumber.split(DELIMITER)));
    }

    private void validateNullAndEmpty(String manualNumber) {
        if (manualNumber == null || manualNumber.isBlank()) {
            throw new IllegalArgumentException("수동 구매 번호가 널이거나 공백입니다.");
        }
    }

    @Override
    public Set<String> getNumbers(Integer count) {
        return values;
    }
}
