package game.lotto.view;

import game.lotto.model.Amount;
import game.lotto.model.Lotto;
import game.lotto.model.Report;

import java.util.List;

public class ResultView {

    public static void printAmount(Amount amount) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", amount.getManualCount(), amount.getAutoCount());
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
        System.out.println();
    }

    public static void printReport(Report report) {
        System.out.println();
        System.out.println(report.makeStringReport());
        System.out.println();
    }

}
