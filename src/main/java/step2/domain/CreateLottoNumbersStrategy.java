package step2.domain;

import java.util.List;

@FunctionalInterface
public interface CreateLottoNumbersStrategy {
    List<LottoNumber> create();
}
