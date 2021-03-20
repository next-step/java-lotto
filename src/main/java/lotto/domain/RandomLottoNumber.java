package lotto.domain;

import java.util.*;

 public class RandomLottoNumber implements LottoNumber {
    private List<Integer> numbers;

    public RandomLottoNumber() {
        numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
    }

    @Override
    public List<Integer> numbers() {
        Collections.shuffle(numbers, new Random());
        return new ArrayList<>(numbers.subList(0, 6));
    }
}