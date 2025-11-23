package lottoGame.view;

import static java.lang.String.join;

import java.util.List;
import lottoGame.model.lotto.Lotto;
import lottoGame.model.lotto.Lottos;

public class OutputView {

    public static void printQuestionByBuyPrice() {
        System.out.println("구입금액을 입력해 주세요");
    }

    public static void printBuyLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printPerLottoNums(String perLottoNums) {
        System.out.println(perLottoNums);
    }

    public static void printQuestionBeforeWinNums() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printWinResultMsg(WinResultDto winResultDto) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(winResultDto.toString());
    }
}
