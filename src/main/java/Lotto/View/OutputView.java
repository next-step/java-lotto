package Lotto.View;

import Lotto.Exception.CustomException;
import Lotto.Model.LottoCard;
import Lotto.Model.LottoGame;
import Lotto.Model.Prize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String NEW_LINE = "\n";

    private OutputView() {
        throw new CustomException("유틸성클래스는 인스턴스 생성을 할 수 없습니다.");
    }

    public static void printBuyCount(int count) {
        System.out.printf("%d개를 구매했습니다.\n", count);
    }

    public static void printLottoGame(List<LottoCard> lottoList) {
        for (LottoCard lottoCard : lottoList) {
            System.out.print('[');
            printLottoCard(lottoCard);
            System.out.print(']');
            System.out.print(NEW_LINE);
        }
    }

    public static void printLottoCard(LottoCard lottoCard) {
        System.out.print(lottoCard.getLotto()
                .stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", ")));
    }

    public static void printPrize(LottoGame lottoGame) {
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---------");

        List<LottoCard> lottoCards = lottoGame.getLottoList();
        List<Prize> prizes =new ArrayList<>();

        for(LottoCard lottoCard : lottoCards){
            prizes.add(lottoCard.getPrize());
        }

        for (Prize prize : Prize.values()) {
            if(prize == Prize.MISS){
                continue;
            }

            if(prize.getCheckBonus()){
                System.out.println(prize.getCountOfMatch() + "개 일치, 보너스 볼 일치 (" + prize.getWinningMoney() + "원) - " + Collections.frequency(prizes, prize) + "개");
                continue;
            }

            System.out.println(prize.getCountOfMatch() + "개 일치 (" + prize.getWinningMoney() + "원) - " + Collections.frequency(prizes, prize) + "개");
        }

        System.out.printf("총 수익률은 %.2f입니다.%n", lottoGame.getWinningRate());
    }
}
