package step2;

import java.util.List;

@FunctionalInterface
public interface CreateLottoNumbersStrategy {
    List<LottoNumber> create();
}
