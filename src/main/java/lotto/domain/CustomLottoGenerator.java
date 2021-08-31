package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CustomLottoGenerator implements LottoGenerator {

    private final List<Integer> customLotto;

    public CustomLottoGenerator(List<Integer> customLotto) {
        this.customLotto = customLotto;
    }

    @Override
    public Lotto generateLotto() {
        Set<LottoNumber> lottoNumbers = customLotto.stream()
                .map(lottoNumber -> LottoNumber.of(lottoNumber)).collect(Collectors.toSet());
        return new Lotto(lottoNumbers);
    }
}
