package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private List<Integer> numbers;
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public LottoNumbers() {
        numbers = getRandomNumbers();
    }

    public LottoNumbers(String values) {
        String[] lottoNumbers = split(values);
        if (isWrongLottoSize(lottoNumbers)) {
            throw new IllegalArgumentException("잘못된 로또 사이즈입니다.");
        }

        if (isWrongLottoNumber(toInts(lottoNumbers))) {
            throw new IllegalArgumentException("잘못된 로또 번호입니다. (1~45 범위초과)");
        }

        numbers = toInts(lottoNumbers);
    }

    private boolean isWrongLottoNumber(List<Integer> numbers) {
        List<Integer> overNumbers = numbers.stream()
                .filter(number -> number > MAX_NUMBER || number < MIN_NUMBER)
                .collect(Collectors.toList());

        return !overNumbers.isEmpty();
    }

    public List<Integer> getValue() {
        return this.numbers;
    }

    private boolean isWrongLottoSize(String[] values) {
        return values.length != LOTTO_NUMBER_COUNT;
    }

    private List<Integer> toInts(String[] values) {
        List<Integer> numbers = new ArrayList<>(values.length);
        for (String value : values) {
            numbers.add(Integer.parseInt(value.trim()));
        }
        return numbers;
    }

    private String[] split(String lottoNumbers) {
        return lottoNumbers.split(",");
    }

    private List<Integer> getRandomNumbers() {
        List<Integer> numbers = new ArrayList<>(LOTTO_NUMBER_COUNT);
        for (int i = 0; i <numbers.size() ; i++) {
            numbers.add(shuffle(getLottoAllNumbers()).get(i));
        }
        Collections.sort(numbers);
        return numbers;
    }

    private List<Integer> shuffle(List<Integer> numbers) {
        Collections.shuffle(numbers);
        return numbers;
    }

    private List<Integer> getLottoAllNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            lottoNumbers.add(i);
        }
        return lottoNumbers;
    }

}
