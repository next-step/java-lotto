package lotto.ui;

import java.io.IOException;
import java.util.List;

public interface LottoInputHandler {

    int scanLottoPurchaseBudget();

    int scanCountOfManualLotto();

    List<String> scanManualLottos(int manualCount) throws IOException;

    String scanLottoWinNumbersString();

    int scanLottoBonusNumber();

}
