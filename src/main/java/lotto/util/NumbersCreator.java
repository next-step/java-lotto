package lotto.util;

import lotto.model.dto.LottoNumber;

import java.util.List;

@FunctionalInterface
public interface NumbersCreator {

    List<LottoNumber> create();
}
