package study.lotto.step2.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private static final int NUMBER_OF_SELECT = 6;
    private static final int MINIMUM_SELECT_NUMBER = 1;
    private static final int MAXIMUM_SELECT_NUMBER = 45;
    private final List<Integer> selectedNumbers;

    public Lotto(List<Integer> selectedNumbers) {
        validateSelectedNumbers(selectedNumbers);
        this.selectedNumbers = selectedNumbers;
    }

    public List<Integer> selectedNumbers() {
        return selectedNumbers;
    }

    private void validateSelectedNumbers(List<Integer> selectedNumbers) {
        if(selectedNumbers.size() != NUMBER_OF_SELECT) {
            throw new IllegalArgumentException("로또 번호 선택 갯수는 " + NUMBER_OF_SELECT + "개입니다: " + selectedNumbers.size());
        }

        selectedNumbers.stream()
                .filter(this::isOutOfRange)
                .findAny()
                .ifPresent(outOfRangeNumber -> {
                    throw new IllegalArgumentException("로또 번호는 " + MINIMUM_SELECT_NUMBER + " 이상 "
                            + MAXIMUM_SELECT_NUMBER + " 이하의 정수입니다: " + outOfRangeNumber);
                });
    }

    private boolean isOutOfRange(int selectedNumber) {
        return selectedNumber < MINIMUM_SELECT_NUMBER || MAXIMUM_SELECT_NUMBER < selectedNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(selectedNumbers, lotto.selectedNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(selectedNumbers);
    }
}
