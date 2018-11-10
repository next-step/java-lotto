package net.chandol.lotto.endpoint;

import net.chandol.lotto.domain.Lotto;
import net.chandol.lotto.domain.LottoGameResult;

import java.util.List;
import java.util.Scanner;

import static net.chandol.lotto.domain.LottoPrize.*;
import static net.chandol.lotto.util.ConsoleUiUtil.formatLotto;

public class ConsoleUi {
    private Scanner scanner = new Scanner(System.in);

    public Integer getInputNumber(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    public String getInputString(String message) {
        System.out.println(message);
        return scanner.next();
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매하였습니다.");

        for (Lotto lotto : lottos) {
            String formattedLottoNumber = formatLotto(lotto);
            System.out.println(formattedLottoNumber);
        }
    }

    public void printLottoGameResult(LottoGameResult lottoGameResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println(lottoGameResult.getFormattedResult(_4));
        System.out.println(lottoGameResult.getFormattedResult(_3));
        System.out.println(lottoGameResult.getFormattedResult(_2));
        System.out.println(lottoGameResult.getFormattedResult(_1));

        Double profitRate = lottoGameResult.getProfitRate();
        System.out.println(String.format("총 수익률은 %.2f 입니다", profitRate));
    }
}
