package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoInputParser {
    private final int upperBound;
    private final int lowerBound;
    private final int lottoNumberCount;

    public LottoInputParser(int upperBound, int lowerBound, int lottoNumberCount) {
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        this.lottoNumberCount = lottoNumberCount;
    }

    public List<Integer> parse(String input, int bonusNumber) {
        List<Integer> list = parse(input);
        parseNumber(String.valueOf(bonusNumber));

        if (list.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자가 당첨번호에 존재할 수 없습니다");
        }

        return list;
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

        if (hasDuplicates(lottoNumbers)) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
        }

        return lottoNumbers;
    }

    private boolean hasDuplicates(List<Integer> lottoNumbers) {
        Set<Integer> unique = new HashSet<>(lottoNumbers);
        return unique.size() < lottoNumbers.size();
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

    public  List<Integer> generateRangeSet() {
        List<Integer> result = new ArrayList<>();
        for (int i = lowerBound; i <= upperBound; i++) {
            result.add(i);
        }
        return result;
    }
}
