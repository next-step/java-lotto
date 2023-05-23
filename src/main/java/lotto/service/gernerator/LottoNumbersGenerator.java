package lotto.service.gernerator;

import lotto.domain.LottoNumbers;
import lotto.model.request.ReqLotto;

import java.util.List;

public interface LottoNumbersGenerator<T extends ReqLotto> {
    List<LottoNumbers> generateLottoNumbers(T t);
}
