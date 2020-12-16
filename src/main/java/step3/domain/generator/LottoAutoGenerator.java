package step3.domain.generator;

import step3.domain.Lotto;
import step3.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoAutoGenerator implements LottoGenerator {
    private final int AUTO_VARARGS_SIZE = 0;

    private List<LottoNumber> lottoNumbers;

    public LottoAutoGenerator() {
        this.lottoNumbers = new ArrayList<>();
        for (int i=START_NUMBER; i<=END_NUMBER; i++) lottoNumbers.add(new LottoNumber(i));
    }

    @Override
    public Lotto generate(String... varargs) {
        if(isNotMatchArgs(varargs)) throw new IllegalArgumentException();

        Collections.shuffle(lottoNumbers);
        return new Lotto(
                lottoNumbers.stream()
                        .limit(LOTTO_COUNT)
                        .sorted(Comparator.comparing(LottoNumber::getNumber))
                        .collect(Collectors.toList()));
    }

    @Override
    public boolean isNotMatchArgs(String... varargs) {
        return varargs.length != AUTO_VARARGS_SIZE;
    }
}
