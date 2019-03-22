package lottery.supplier;

import java.util.List;

@FunctionalInterface
public interface NumbersGenerator {
    List<Integer> nextNumbers(int size);
}
