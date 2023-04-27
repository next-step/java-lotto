package step2.domain.strategy.lotto;

import step2.domain.model.Lotto.LottoNumber;

import java.util.List;

public interface Strategy {
    List<LottoNumber> createLottoNumber();
    List<LottoNumber> createWinningLotto(String lastWinningNumbers);
}
