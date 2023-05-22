package study.lotto.view;

import study.lotto.model.LottoNumber;

public interface InputView {
  int getAmount();

  LottoNumber previousWinningNumbers();
}
