package lotto.strategy;

import lotto.model.lotto.LottoNumber;

import java.util.SortedSet;

public interface DrawingStrategy {
    int NUMBER_COUNT = 6;
    int THRESHOLD = 45;

    SortedSet<LottoNumber> drawNumbers();

}
