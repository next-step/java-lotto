package step2.controller;

import java.util.List;
import java.util.Map;
import step2.model.Lotto;
import step2.model.Lottos;
import step2.view.LottoInput;
import step2.view.LottoOutput;
import step2.view.LottoResultDto;

public class LottoMain {

    public static void main(String[] args) {
        //구매금액 입력
        int money = LottoInput.readMoney();
        Lottos lottos = new Lottos(money);

        //현황 출력
        LottoOutput.printLottos(lottos);
        System.out.println();

        //winner 로또 생성
        List<Integer> winnerNumbers = LottoInput.readWinnerNumbers();
        Lotto winner = new Lotto(winnerNumbers);

        //결과 파악
        Map<Integer, Integer> winners = lottos.getWinners(winner);
        double yield = lottos.getYield(winner);

        //결과 출력
        LottoResultDto result = new LottoResultDto(winners, yield);
        LottoOutput.printLottoResult(result);
    }
}
