package step4.view;

import step4.domain.lotto.WinningNumbers;
import step4.domain.lotto.dto.LottoPurchaseInfoDTO;

import java.util.List;

public interface InputView {
    int getUseAmount();

    WinningNumbers getWinningNumbers();

    int getManualTicketSize(int useAmount);

    List<String> getManualNumbers(int manualSize);

    LottoPurchaseInfoDTO getPurchaseInfo();
}
