package lotto.util;

import lotto.model.dto.LottoNumber;

@FunctionalInterface
public interface BonusCreator {
    LottoNumber create();
}
