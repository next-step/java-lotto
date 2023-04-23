package calculator.domain.extractor;

import java.util.List;

@FunctionalInterface
public interface Extractor<T> {
    T extract(List<String> inputList);
}
