package lotto.step2.domain;

import java.util.*;

public class Numbers {

    private static final int LOTTO_NUMBER = 46;
    private static final int LOTTO_INDEX = 6;
    private List<Integer> numbers = new ArrayList<>();

    // 테스트 생성자
    public Numbers() {
        createRandomNumber();
    }

    public Numbers(List<Integer> list) {
        numbers = list;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getCountOfMatch(List<Integer> winningNumbers) {
        Collections.sort(numbers);
        Collections.sort(winningNumbers);
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private void createRandomNumber() {
        int[] array = new int[LOTTO_NUMBER];
        for (int i = 0; i < LOTTO_NUMBER; i++) {
            array[i] = i + 1;
        }
        for (int i = 0; i < LOTTO_INDEX; i++) {
            numbers.add(array[new Random().nextInt(LOTTO_NUMBER - 1) + 1]);
        }
        Collections.shuffle(numbers);
    }

    @Override
    public String toString() {
        return "" + numbers;
    }

}
