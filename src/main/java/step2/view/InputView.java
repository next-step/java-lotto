package step2.view;

import step2.domain.lotto.WinningNumbers;

import java.util.Scanner;

public interface InputView {
    int getUseAmount(Scanner scanner);
    WinningNumbers getWinningNumber(Scanner scanner);
}
