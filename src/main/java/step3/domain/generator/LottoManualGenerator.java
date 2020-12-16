package step3.domain.generator;

import step3.domain.Lotto;
import step3.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoManualGenerator implements LottoGenerator {
    private static final int VARARGS_MIN_SIZE = 1;

    @Override
    public Lotto generate(String... numbers) {
        if (numbers == null || numbers.length < VARARGS_MIN_SIZE) throw new IllegalArgumentException();

        String[] numbersArray = numbers[0].split(",");
        List<LottoNumber> lotto = new ArrayList<>();

        for (String number : numbersArray) {
            lotto.add(new LottoNumber(Integer.parseInt(number)));
        }
        return new Lotto(lotto);
    }
}
