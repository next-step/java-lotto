package lotto.strategy;

import lotto.exception.LottoNumberException;
import lotto.exception.NotPositiveException;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualNumberStrategy implements LottoNumberStrategy {

    private static final int START = 1;
    private static final int END = 45;
    private static final int COUNT = 6;
    private static final String SEPARATOR = ",";
    
    private final List<Integer> numbers;

    public ManualNumberStrategy(String input) {
        checkNull(input);
        List<Integer> inputNumbers = inputToLottoNumbers(input);
        checkNumbers(inputNumbers);
        numbers = new ArrayList<>(inputNumbers);
    }

    @Override
    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> inputToLottoNumbers(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(strNumber -> {
                    checkNotPositive(strNumber.trim());
                    return Integer.parseInt(strNumber.trim());
                })
                .collect(Collectors.toList());
    }

    private void checkNull(String input) {
        if (StringUtils.isBlank(input)) {
            throw new NotPositiveException();
        }
    }

    private void checkNotPositive(String input) {
        if (!StringUtils.isNumeric(input)) {
            throw new NotPositiveException();
        }
        if (Integer.parseInt(input) < START) {
            throw new NotPositiveException();
        }
    }

    private void checkNumbers(List<Integer> inputNumbers) {
        if (inputNumbers.size() != COUNT) {
            throw new LottoNumberException();
        }
        inputNumbers.forEach(number -> {
            if (number < START || number > END) {
                throw new LottoNumberException();
            }
        });
        if (inputNumbers.stream().distinct().count() != COUNT) {
            throw new LottoNumberException();
        }
    }
}
