package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoManualGenerator implements GenerateStrategy {
    private final List<Integer> parsedNumber;

    public LottoManualGenerator(final List<Integer> parsedNumber) {
        this.parsedNumber = new ArrayList<>(parsedNumber);
    }

    @Override
    public List<LottoNumber> generateNumbers() {
        return convertToLottoNumbers(parsedNumber);
    }

    private List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }




}
