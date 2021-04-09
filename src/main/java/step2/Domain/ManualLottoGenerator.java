package step2.Domain;

import step2.Domain.InputNumber;
import step2.Domain.LottoNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoNumberGenerator {

    private final List<InputNumber> inputNumbers;

    public ManualLottoGenerator(List<InputNumber> inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    @Override
    public List<Lotto> generate() {
        return inputNumbers.stream()
                .map(inputNumber -> new Lotto(inputNumber))
                .collect(Collectors.toList());
    }
}
