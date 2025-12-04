package lottogame.view;

public class
OutputView {

    public static void printQuestionByBuyPrice() {
        System.out.println("구입금액을 입력해 주세요");
    }

    public static void printQuestionManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요");
    }

    public static void printQuestionManualLottoNums() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void printBuyLottoCount(int autoCount, int manualCount) {
        System.out.println(
                "수동으로 " + manualCount + "장"
                + "자동으로 " +autoCount + "개를 구매했습니다."
        );
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
