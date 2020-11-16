package step4.view;

import step4.domain.lotto.WinningNumbers;

import java.util.List;

public interface InputView {
    int getUseAmount();
    WinningNumbers getWinningNumber();

    int getManualTicketSize();

    List<String> getManualNumbers(int manualSize);
}
