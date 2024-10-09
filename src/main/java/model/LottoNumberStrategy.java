package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface LottoNumberStrategy {
    default List<List<Integer>> create(int totalPrice, int priceOfALotto) {
        int cnt = totalPrice / priceOfALotto;
        List<List<Integer>> numberSet = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            List<Integer> shuffledNumbers = getShuffledNumbers();
            numberSet.add(shuffledNumbers);
        }

        return numberSet;
    }

    private static List<Integer> getShuffledNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int j = 1; j <= 45; j++) {
            numbers.add(j);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }
}
