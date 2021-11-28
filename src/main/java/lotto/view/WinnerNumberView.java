package lotto.view;

import lotto.domain.dto.WinningNumberDto;
import lotto.util.ScannerUtils;

public class WinnerNumberView {

    private static final String MESSAGE_WINNER_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private WinnerNumberView() {
    }

    public static WinningNumberDto getWinningNumberDto() {
        return WinningNumberDto.from(getWinningNumbers(), getBonusNumber());
    }

    private static String getWinningNumbers() {
        System.out.println(MESSAGE_WINNER_NUMBERS);
        return ScannerUtils.nextLine();
    }

    private static int getBonusNumber() {
        System.out.println(MESSAGE_BONUS_NUMBER);
        return ScannerUtils.nextInt();
    }

}
