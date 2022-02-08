package lotto.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class NumberGenerator {

    private final List<Integer> numberList;

    public NumberGenerator(int min, int max, int size) {
        numberList = generatorLotto(min, max, size).stream().collect(Collectors.toList());
    }

    public static NumberGenerator of(int min, int max, int size) {
        return new NumberGenerator(min, max, size);
    }

    public List<Integer> getNumberList() {
        return Collections.unmodifiableList(numberList);
    }

    private int generateNumber(int min, int max) {
        return new Random().nextInt(max + min) + max;
    }

    private HashSet<Integer> generatorLotto(int min, int max, int size) {
        HashSet<Integer> lottoList = new HashSet<>();

        while (lottoList.size() < size) {
            lottoList.add(generateNumber(min, max));
        }

        return lottoList;
    }
}
