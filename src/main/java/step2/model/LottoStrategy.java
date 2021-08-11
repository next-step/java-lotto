package step2.model;

import java.util.ArrayList;
import java.util.List;

public interface LottoStrategy {
    int MIN = 1;
    int MAX = 45;
    int NUMBER_COUNT = 6;
    List<Integer> numberList = new ArrayList<>();

    List<Integer> getNumbers();
}
