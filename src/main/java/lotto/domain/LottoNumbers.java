package lotto.domain;

import lotto.utils.LottoMachine;

import java.util.HashSet;
import java.util.Set;

public class LottoNumbers {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int BEGIN_INDEX = 0;

    private Set<LottoNumber> numbers;

    public LottoNumbers() {
        this(generatedLottoNumbers());
    }

    public LottoNumbers(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new RuntimeException("로또 번호의 개수는 6개여야 합니다.");
        }
        this.numbers = numbers;
    }

    private static Set<LottoNumber> generatedLottoNumbers() {
        LottoMachine.initLottoNumbers();

        Set<LottoNumber> numbers = new HashSet<>();
        for (int i = BEGIN_INDEX; i < LOTTO_NUMBERS_SIZE; i++) {
            numbers.add(new LottoNumber(LottoMachine.drawnNumber()));
        }
        return numbers;
    }

    public Set<LottoNumber> value() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
