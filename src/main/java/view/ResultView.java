package view;

import domain.Lotto;

import java.util.List;
import java.util.Scanner;

public class ResultView {

    private ResultView() {
    }

    public static void printLottoCount(Long count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Lotto> lottoTickets) {
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getLottoNumbers());
        }
        System.out.println("");
    }

    public static void printWinningResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");

    }
}
