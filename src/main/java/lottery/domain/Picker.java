package lottery.domain;

import java.util.List;

@FunctionalInterface
public interface Picker {
    List<Integer> pick();
}
