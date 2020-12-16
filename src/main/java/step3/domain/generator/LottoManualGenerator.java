package step3.domain.generator;

import step3.domain.Lotto;
import step3.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoManualGenerator implements LottoGenerator {
    private final int MANUAL_VARARGS_SIZE = 1;

    @Override
    public Lotto generate(String... varargs) {
        if (isNotMatchArgs(varargs)) throw new IllegalArgumentException();

        String[] numbersArray = varargs[0].split(",");
        List<LottoNumber> lotto = new ArrayList<>();

        for (String number : numbersArray) {
            lotto.add(new LottoNumber(Integer.parseInt(number)));
        }
        return new Lotto(lotto);
    }

    @Override
    public boolean isNotMatchArgs(String... varargs) {
        return varargs.length != MANUAL_VARARGS_SIZE;
    }
}
