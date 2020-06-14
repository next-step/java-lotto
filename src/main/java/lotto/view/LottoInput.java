package lotto.view;

import lotto.model.LottoLine;

public interface LottoInput {
    int getPurchacePrice();

    LottoLine getWinnerLine();

    int getBonusNumber();
}
