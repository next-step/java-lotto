package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public interface ExtractStrategy {
    List<Integer> extractNumber(int number);
}
