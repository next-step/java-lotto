package lottoGame.view;

import static java.lang.String.join;

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

    public static void printQuestionBonusLottoNum() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public static void printWinResultMsg(String winResultMessage) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(winResultMessage);
    }
}
