package lotto;

import java.util.List;

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
    }

    public static void showWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void showBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }
}
