package step2;

import java.util.List;

public class TestLottoNumberGenerator implements LottoNumberGenerator{

    private final List<Integer> numbers;

    public TestLottoNumberGenerator(List<Integer> lottoNumbers){
        this.numbers = lottoNumbers;
    }

    @Override
    public List<Integer> generateNumbers() {
        return numbers;
    }
}
