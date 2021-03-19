package lotto.strategy;

import java.util.List;

public interface Numbers {
    int LOTTO_NUMBER_COUNT = 6;
    int MIN_NUMBER = 1;
    int MAX_NUMBER = 45;

    List<Integer> readOnlyNumbers();

    boolean checkNumbers(List<Integer> numbers);
}
