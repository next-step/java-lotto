package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    static LottoGame lottoGame;
    public static void printLottoTicket() {
        for (int ii = 0; ii < lottoGame.getTickets().size(); ii++ )
            System.out.println(lottoGame.getTickets().get(ii).getLottoNumber().toString());
    }

    public static void printWinnumber() {
        for (int ii = 0; ii < lottoGame.getTickets().size(); ii++ )
            System.out.println(lottoGame.getTickets().get(ii).getLottoNumber().toString() + lottoGame.getTickets().get(ii).getWinLevel());
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
        printWinnumber();
    }
}
