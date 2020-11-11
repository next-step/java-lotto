package step2;

import java.util.List;

@FunctionalInterface
public interface CreateLottoNumberStrategy {
    List<Integer> create();
}
