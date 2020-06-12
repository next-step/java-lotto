package lotto.domain;

import lotto.NumberInputScanner;
import lotto.StringInputScanner;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoNumbers implements LottoNumbers {

    private static final int MIN_INPUT_VALUE = 0;
    StringInputScanner stringInputScanner = new StringInputScanner();
    NumberInputScanner numberInputScanner = new NumberInputScanner();


    @Override
    public List<LottoNo> generateNumbers() {
        List<Integer> numbers = stringInputScanner.getNumbers();
        List<LottoNo> lottoNumbers = numbers.stream()
                .map(integer -> new LottoNo(integer))
                .collect(Collectors.toList());
        return lottoNumbers;
    }

    public LottoNo generateNumber() {
        int number = numberInputScanner.getNumber();
        validateManualNumber(number);
        return new LottoNo(number);
    }

    private void validateManualNumber(int number) {
        if(number <= MIN_INPUT_VALUE) {
            throw new IllegalArgumentException("Input number should be more than 0");
        }
    }
}
