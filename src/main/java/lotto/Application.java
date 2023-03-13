package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    static final int WIN_PRICE_LEVEL5 = 5000;
    static final int WIN_PRICE_LEVEL4 = 50000;
    static final int WIN_PRICE_LEVEL3 = 1500000;
    static final int WIN_PRICE_LEVEL2 = 30000000;
    static final int WIN_PRICE_LEVEL1 = 2000000000;
    static LottoGame lottoGame;
    public static void printLottoTicket() {
        for (LottoTicket newLotto: lottoGame.getTickets())
            System.out.println(newLotto.getLottoNumber().toString());
    }

    public static void printWinNumber(int money) {
        int[] winPrice = {WIN_PRICE_LEVEL1, WIN_PRICE_LEVEL2, WIN_PRICE_LEVEL3, WIN_PRICE_LEVEL4, WIN_PRICE_LEVEL5};
        int[] winLotto = new int[LottoGame.LOTTO_LEVEL_5];
        int   winAmount = 0;

        for (LottoTicket newLotto: lottoGame.getTickets()) {
            if (newLotto.getWinLevel() == 0)
                continue;
            winLotto[newLotto.getWinLevel() - 1]++;
            winAmount += winPrice[newLotto.getWinLevel() - 1];
        }

        System.out.println("당첨통계");
        System.out.println("-------");
        System.out.println("3개 일치 (5000원)-"+winLotto[LottoGame.LOTTO_LEVEL_5-1]+"개");
        System.out.println("4개 일치 (50000원)-"+winLotto[LottoGame.LOTTO_LEVEL_4-1]+"개");
        System.out.println("5개 일치 (1500000원)-"+winLotto[LottoGame.LOTTO_LEVEL_3-1]+"개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) -"+winLotto[LottoGame.LOTTO_LEVEL_2-1]+"개");
        System.out.println("6개 일치 (2000000000원)-"+winLotto[LottoGame.LOTTO_LEVEL_1-1]+"개");
        System.out.println("총 수익률은"+winAmount/money+"입니다.");
    }
    public static  void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int    lottoMoney = scan.nextInt();
        scan.nextLine();
        lottoGame = new LottoGame(lottoMoney);
        System.out.println(lottoGame.getTickets().size()+"를 구매했습니다.");
        printLottoTicket();
        System.out.println("당첨번호를 입력해주세요.");
        String    winNumbers = scan.nextLine();

        System.out.println("보너스번호를 입력해주세요.");
        String    bonusNumber = scan.nextLine();

        lottoGame.checkWin(winNumbers, bonusNumber);
        printWinNumber(lottoMoney);
    }
}
