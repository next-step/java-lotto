package Lotto.model.NumberExtractor;

import Lotto.view.InputView;

import java.util.List;

public interface NumberExtractor {
    List<Integer> extract(int size, int min, int max);
}
