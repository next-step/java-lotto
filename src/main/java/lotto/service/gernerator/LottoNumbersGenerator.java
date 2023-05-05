package lotto.service.gernerator;

import lotto.domain.LottoNumbers;
import lotto.model.request.ReqLotto;

import java.util.List;

public interface LottoNumbersGenerator<T extends ReqLotto> {
    LottoNumbers generateLottoNumbers(T t);

    List<LottoNumbers> bulkGenerateLottoNumbers(T t);
}
