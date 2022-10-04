package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.Reward;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void printResult(Result result) {
        for (int matchingCount : Reward.getRewardMap().keySet()) {
            System.out.println(matchingCount + "개 일치 (" + Reward.getReward(matchingCount) + "원)- " + result.getWinCount(matchingCount) + "개");
        }
        System.out.println("총 수익률은 " + result.getRateOfIncome() + "입니다");
    }

    public void printLottoNumber(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLottoNumber(lotto);
        }
    }

    private void printLottoNumber(Lotto lotto) {
        System.out.println("[" + lotto.getNumbers().stream().map(Object::toString).collect(Collectors.joining(", ")) + "]");
    }

}