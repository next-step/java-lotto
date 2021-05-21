package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int LOTTO_SIZE = 6;
    public List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }


    public int matchCountWith(Lotto other) {
        Set<Integer> union = new HashSet<>(numbers);
        union.addAll(other.numbers);
        return LOTTO_SIZE * 2 - union.size();
    }
}
