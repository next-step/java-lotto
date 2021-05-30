package lotto;

public class Output {
    public static void showBuyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void showLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void showLottoTickets(LottoTickets lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            System.out.println(lottoTicket);
        }
        System.out.println();
    }

    public static void showWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void showBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public static void showWinningStatus(WinningResult winningResult, double yield) {
        System.out.println("당첨통계\n-------------------------\n"
                + "3개 일치 (5000원)- " + winningResult.countFifthPlace() + "개\n"
                + "4개 일치 (50000원)- " + winningResult.countFourthPlace() + "개\n"
                + "5개 일치 (1500000원)- " + winningResult.countThirdPlace() + "개\n"
                + "5개 일치, 보너스 볼 일치(30000000원)- " + winningResult.countSecondPlace() + "개\n"
                + "6개 일치 (2000000000원)- " + winningResult.countFirstPlace() + "개\n"
                + "총 수익률은 " + yield + "입니다."
        );
    }


}
