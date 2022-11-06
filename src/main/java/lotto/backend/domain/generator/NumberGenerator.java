package lotto.backend.domain.generator;

import lotto.backend.domain.LottoNumber;
import lotto.backend.domain.LottoType;

import java.util.Set;

public interface NumberGenerator {

    Set<LottoNumber> create(int size);

    LottoType getLottoType();
}
