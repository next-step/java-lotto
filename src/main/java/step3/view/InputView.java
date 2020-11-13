package step3.view;

import step3.domain.lotto.WinningNumbers;

import java.util.Scanner;

public interface InputView {
    int getUseAmount(Scanner scanner);
    WinningNumbers getWinningNumber(Scanner scanner);
}
