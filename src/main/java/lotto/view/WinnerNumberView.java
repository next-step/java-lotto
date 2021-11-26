package lotto.view;

import lotto.domain.dto.WinnerNumberDto;
import lotto.util.ScannerUtils;

public class WinnerNumberView {

    private static final String MESSAGE_WINNER_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_BONUS_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    private WinnerNumberView() {
    }

    public static WinnerNumberDto getWinnerNumberDto() {
        return WinnerNumberDto.from(getWinnerNumber(), getBonusNumber());
    }

    private static String getWinnerNumber() {
        System.out.println(MESSAGE_WINNER_NUMBERS);
        return ScannerUtils.nextLine();
    }
    
    private static int getBonusNumber() {
        System.out.println(MESSAGE_BONUS_NUMBER);
        return ScannerUtils.nextInt();
    }

}
