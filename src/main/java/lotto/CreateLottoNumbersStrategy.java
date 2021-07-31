package lotto;

import java.util.List;

@FunctionalInterface
public interface CreateLottoNumbersStrategy {
    List<Integer> getNumbersList();
}
