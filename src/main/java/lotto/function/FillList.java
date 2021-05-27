package lotto.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class FillList<T> implements BiFunction<Integer, Supplier<T>, List<T>> {

    @Override
    public List<T> apply(Integer index, Supplier<T> supplier) {
        List<T> result = new ArrayList<>();

        for (int i = 0; i < index; i++) {
            result.add(supplier.get());
        }

        return result;
    }
}
