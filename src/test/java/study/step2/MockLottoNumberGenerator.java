package study.step2;

import study.step2.domain.LottoNumberGenerator;

import java.util.List;

public class MockLottoNumberGenerator implements LottoNumberGenerator {

    private final List<Integer> numbers;

    public MockLottoNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
