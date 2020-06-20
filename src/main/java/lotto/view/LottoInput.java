package lotto.view;

import lotto.model.LottoLine;

import java.util.List;

public interface LottoInput {
    int getPurchasePrice();

    LottoLine getWinnerLine();

    int getBonusNumber();

    List<LottoLine> getManualLottoLines();
}
