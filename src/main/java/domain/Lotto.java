package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private List<Integer> sixNumbers;

    public Lotto(List<Integer> sixNumbers) {
        Objects.requireNonNull(sixNumbers);
        this.sixNumbers = sixNumbers;

    }

    @Override
    public String toString() {
        return sixNumbers.toString();
    }
}
