package lotto.backend.domain.generator;

import lotto.backend.domain.LottoNumber;
import lotto.backend.domain.LottoType;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomNumberGenerator implements NumberGenerator {

    private final LottoType lottoType = LottoType.CUSTOM;

    private final List<Integer> customNumber;

    public CustomNumberGenerator(List<Integer> customNumber) {
        this.customNumber = customNumber;
    }

    @Override
    public Set<LottoNumber> create(int numberSize) {
        return customNumber.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    @Override
    public LottoType getLottoType() {
        return lottoType;
    }
}
