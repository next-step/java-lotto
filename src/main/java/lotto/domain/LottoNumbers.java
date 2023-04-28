package lotto.domain;

import lotto.utils.LottoMachine;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int BEGIN_INDEX = 0;

    private final List<LottoNumber> numbers;

    public LottoNumbers() {
        this(generatedLottoNumbers());
    }

    public LottoNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new RuntimeException("로또 번호의 개수는 6개여야 합니다.");
        }
        this.numbers = numbers;
    }

    private static List<LottoNumber> generatedLottoNumbers() {
        LottoMachine.initLottoNumbers();

        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = BEGIN_INDEX; i < LOTTO_NUMBERS_SIZE; i++) {
            numbers.add(new LottoNumber(LottoMachine.drawnNumber()));
        }
        return numbers;
    }

    public List<LottoNumber> value() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
