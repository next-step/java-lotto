package lotto;

import java.util.ArrayList;
import java.util.List;

public interface AutomaticStrategy {

    int SIZE = 6;

    ArrayList<Integer> choose(List<Integer> numbers);
}
