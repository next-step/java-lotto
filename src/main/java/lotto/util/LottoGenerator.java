package lotto.util;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoGenerator {

    public static Random random = new Random();

    public static List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(random.nextInt(45) + 1);
        numbers.add(random.nextInt(45) + 1);
        numbers.add(random.nextInt(45) + 1);
        numbers.add(random.nextInt(45) + 1);
        numbers.add(random.nextInt(45) + 1);
        numbers.add(random.nextInt(45) + 1);
        return numbers;
    }
}
