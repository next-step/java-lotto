package lotto.backend.domain.generator;

import lotto.backend.domain.LottoNumber;
import lotto.backend.domain.LottoType;

import java.util.Set;

public class AutoNumberGenerator implements NumberGenerator {

    private final LottoType lottoType = LottoType.AUTO;

    @Override
    public Set<LottoNumber> create(int size) {
        return LottoNumber.createNumbers(size);
    }

    @Override
    public LottoType getLottoType() {
        return lottoType;
    }
}
