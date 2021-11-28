package lotto.view;

import lotto.domain.dto.WinningNumberDto;
import lotto.util.ScannerUtils;

public class WinnerNumberView {

    private WinnerNumberView() {
    }

    public static WinningNumberDto getWinningNumberDto() {
        return WinningNumberDto.from(getWinningNumbers(), getBonusNumber());
    }

    private static String getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return ScannerUtils.nextLine();
    }

    private static int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return ScannerUtils.nextInt();
    }

}
