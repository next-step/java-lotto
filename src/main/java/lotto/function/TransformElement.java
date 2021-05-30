package lotto.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TransformElement<T, U> implements BiFunction<List<T>, Function<T, U>, List<U>> {

    @Override
    public List<U> apply(List<T> source, Function<T, U> function) {
        List<U> result = new ArrayList<>();

        for (T t : source) {
            result.add(function.apply(t));
        }

        return result;
    }
}
