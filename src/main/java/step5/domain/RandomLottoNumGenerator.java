package step5.domain;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class RandomLottoNumGenerator {

    private static final int END_OF_LOTTO_NUM = 45;
    private static final int NUM_OF_LOTTO_BALL = 6;

    public static Lotto createLottoNums() {

        Set<Integer> numbers = new TreeSet<>();
        do {
            int number = (int) (Math.random() * END_OF_LOTTO_NUM) + 1;
            numbers.add(number);
        } while (numbers.size() != NUM_OF_LOTTO_BALL);

        return new Lotto(new ArrayList<>(numbers));
    }

}
