package step2.model;

import java.util.ArrayList;
import java.util.List;

public interface LottoStrategy {
    int MIN = 1;
    int MAX = 45;
    int NUMBER_CNT = 6;
    List<Integer> numbers = new ArrayList<>();

    List<Integer> getNumbers();
}
