package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;

public interface InputView {

    long purchaseAmount();

    int manualQuantity(long purchaseAmount);

    List<Lotto> manualNumbers(int manualQuantity);

    List<Integer> lastWeekWinningNumbers();

    LottoNumber bonusBall();
}
