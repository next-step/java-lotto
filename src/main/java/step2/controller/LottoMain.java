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
        int money = LottoInput.readMoney();
        Lottos lottos = new Lottos(money);

        LottoOutput.printLottos(lottos);
        System.out.println();

        List<Integer> winnerNumbers = LottoInput.readWinnerNumbers();
        Lotto winner = new Lotto(winnerNumbers);
        Map<Integer, Integer> winners = lottos.getWinners(winner);
        double yield = lottos.getYield(winner);

        LottoResultDto result = new LottoResultDto(winners, yield);
        LottoOutput.printLottoResult(result);
    }
}
