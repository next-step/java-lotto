package step2.infrastructure;

import step2.domain.LottoGenerateStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualStrategy implements LottoGenerateStrategy {
    private final List<String> numberList;

    public ManualStrategy(List<String> numberList) {
        this.numberList = numberList;
    }

    @Override
    public List<List<Integer>> generate() {
        List<List<Integer>> numbers = new ArrayList<>();

        for (String number : numberList) {
            String[] splitedNumber = number.split(",");

            List<Integer> splitedNumberList = toList(splitedNumber);
            numbers.add(new ArrayList<>(splitedNumberList));
        }

        return numbers;
    }

    private List<Integer> toList(String[] splitedNumber) {
        return Arrays.stream(splitedNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
