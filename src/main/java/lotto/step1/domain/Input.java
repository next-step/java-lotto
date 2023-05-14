package lotto.step1.domain;

import java.util.List;

public class Input {
    private final List<String> calcList;

    public Input(List<String> calcList) {
        checkValidation(calcList);
        this.calcList = calcList;
    }

    private void checkValidation(List<String> calcList) {
        if (calcList.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        calcList.stream()
                .filter(String::isBlank)
                .findAny()
                .ifPresent(s -> {
                    throw new IllegalArgumentException("입력값은 공백일 수 없습니다.");
                });
    }

    public List<String> getCalcList() {
        return List.copyOf(calcList);
    }

    public boolean isDigit(String e) {
        return Character.isDigit(e.charAt(0));
    }
}
