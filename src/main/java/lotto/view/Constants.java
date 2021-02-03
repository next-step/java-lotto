package lotto.view;

import lotto.wrapper.InputString;
import lotto.wrapper.OutputString;

public class Constants {
    public static final InputString BUY_MSG = new InputString("구입금액을 입력해 주세요.");
    public static final InputString MANUAL_BUY_MSG = new InputString("수동으로 구매할 로또 수를 입력해 주세요.");
    public static final OutputString MANUAL = new OutputString("수동으로");
    public static final OutputString RANDOM = new OutputString(" 자동으로");
    public static final OutputString AMOUNT = new OutputString(" 개");
    public static final OutputString AFTER_BUY_MSG = new OutputString("를 구매했습니다.");
    public static final InputString SELECT_LOTTO_MSG = new InputString("수동으로 구매할 번호를 입력해 주세요.");
    public static final InputString LOTTO_NUMBERS_MSG = new InputString("지난 주 당첨 번호를 입력해 주세요.");
    public static final InputString BONUS_NUMBER_MSG = new InputString("보너스 볼을 입력해 주세요.");
    public static final OutputString RESULT_TITLE_MSG = new OutputString("당첨 통계");
    public static final OutputString RESULT_DELIMITER_MSG = new OutputString("---------");
}
