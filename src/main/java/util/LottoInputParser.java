package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoInputParser {
    private final int upperBound;
    private final int lowerBound;
    private final int lottoNumberCount;

    public LottoInputParser(int upperBound, int lowerBound, int lottoNumberCount) {
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        this.lottoNumberCount = lottoNumberCount;
    }

    public List<Integer> parse(String input) {
        validateInput(input);
        String[] numbers = input.split(", ");

        if (numbers.length != lottoNumberCount) {
            throw new IllegalArgumentException(String.format("로또의 숫자 개수는 %d여야합니다.", lottoNumberCount));
        }

        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : numbers) {
            lottoNumbers.add(parseNumber(number));
        }
        return lottoNumbers;
    }

    private void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("input이 null이거나 빈 문자열입니다.");
        }
    }

    private int parseNumber(String input) {
        int number = Integer.parseInt(input);

        if (number > upperBound) {
            throw new IllegalArgumentException(String.format("input이 %d 보다 큽니다", upperBound));
        }

        if (number < lowerBound) {
            throw new IllegalArgumentException(String.format("input이 %d 보다 작습니다", lowerBound));
        }

        return number;
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> lottoNumbers = generateRangeSet(lowerBound, upperBound);
        List<Integer> shuffledNumbers = new java.util.ArrayList<>(List.copyOf(lottoNumbers)); // Create a copy to avoid modifying the original list
        Collections.shuffle(shuffledNumbers);
        return shuffledNumbers.subList(0, lottoNumberCount);
    }

    private static List<Integer> generateRangeSet(int n, int m) {
        List<Integer> result = new ArrayList<>(n);
        for (int i = n; i <= m; i++) {
            result.add(i);
        }
        return result;
    }
}
