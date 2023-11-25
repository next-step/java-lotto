package lotto.domain;

import java.util.List;

public interface RandomNumberStrategy {

    List<Integer> getRandomNumbers(List<Integer> numbers);
}
