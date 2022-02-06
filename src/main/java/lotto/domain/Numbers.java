package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {

    private final List<Integer> numberData;
    private final List<Integer> numbers;

    public Numbers(int firstNumber, int lastNumber, int size) {
        numberData = getNumberData(firstNumber, lastNumber);
        numbers = getNumbers(size);
    }

    private List<Integer> getNumberData(int firstNumber, int lastNumber) {
        return IntStream.rangeClosed(firstNumber, lastNumber)
            .boxed()
            .collect(Collectors.toList());
    }

    private List<Integer> getNumbers(int size) {
        Collections.shuffle(numberData);
        List<Integer> pickedNumbers = new ArrayList<>(numberData.subList(0, size));
        Collections.sort(pickedNumbers);

        return pickedNumbers;
    }

    public int getSize() {
        return numbers.size();
    }

    public List<Integer> getRawNumbers() {
        return new ArrayList<>(numbers);
    }

    public boolean hasDuplication() {
        return getSize() != numbers.stream().distinct().count();
    }
}
