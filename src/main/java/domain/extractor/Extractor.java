package domain.extractor;

import java.util.List;

public interface Extractor<T> {
    T extract(List<String> input);
}
