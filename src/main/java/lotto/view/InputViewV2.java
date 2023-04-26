package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public interface InputViewV2 {

    long purchaseAmount();

    int manualQuantity(long purchaseAmount);

    List<Lotto> manualNumbers(int manualQuantity);

    List<Integer> lastWeekWinningNumbers();

    int bonusBall();
}
