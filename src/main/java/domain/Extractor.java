package domain;

import java.util.Queue;

public interface Extractor<T> {
    Queue<T> extractToDeque(String text);
}
