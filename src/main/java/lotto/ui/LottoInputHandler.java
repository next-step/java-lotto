package lotto.ui;

import java.util.List;

public interface LottoInputHandler {

    int scanLottoPurchaseBudget();

    int scanCountOfManualLotto();

    List<String> scanManualLottos(int manualCount);

    String scanLottoWinNumbersString();

    int scanLottoBonusNumber();

}
