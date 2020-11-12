package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> lottoNumbers = IntStream.rangeClosed(1,45).boxed().collect(Collectors.toList());
    private final List<Integer> sixNumbers;

    public Lotto() {
        Collections.shuffle(lottoNumbers);
        sixNumbers = lottoNumbers.subList(0,6);
        Collections.sort(sixNumbers);
    }

    @Override
    public String toString() {
        return sixNumbers.toString();
    }
}
