package lotto.strategy;

import lotto.domain.LottoNumber;
import lotto.exception.LottoNumbersException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualNumberStrategy implements LottoNumberStrategy {
    private static final String SEPARATOR = ",";
    private static final int COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public ManualNumberStrategy(String input) {
        List<LottoNumber> inputNumbers = inputToLottoNumbers(input);
        checkNumbers(inputNumbers);
        lottoNumbers = new ArrayList<>(inputNumbers);
    }

    @Override
    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private List<LottoNumber> inputToLottoNumbers(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(strNumber -> new LottoNumber(strNumber))
                .collect(Collectors.toList());
    }

    private void checkNumbers(List<LottoNumber> inputNumbers) {
        if (inputNumbers.size() != COUNT) {
            throw new LottoNumbersException();
        }
        if (inputNumbers.stream().distinct().count() != COUNT) {
            throw new LottoNumbersException();
        }
    }
}
