package strategy;

import java.util.*;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    public static final int MAX_NUMBER_BOUND = 45;
    public static final int LOTTO_NUMBER = 6;

    @Override
    public List<Integer> generator() {
        List<Integer> numberBound = this.getNumberBound();
        Collections.shuffle(numberBound);
        return numberBound.subList(0, LOTTO_NUMBER);
    }

    private List<Integer> getNumberBound() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < MAX_NUMBER_BOUND; i++) {
            numbers.add(i+1);
        }
        return numbers;
    }
}
