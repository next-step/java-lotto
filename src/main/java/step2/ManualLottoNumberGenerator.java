package step2;

import java.util.List;

public class ManualLottoNumberGenerator implements LottoNumberGenerator{

    private final List<Integer> numbers;

    public ManualLottoNumberGenerator(List<Integer> numbers){
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generateNumbers() {
        return numbers;
    }
}
