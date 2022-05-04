package step2.service;

import step2.domain.LottoWinners;
import step2.domain.Lottos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGameService {

    public List<Integer> pickLottoNumberOfWeek(String input) {
        String newInput = input.replace(" ", "");
        String[] split = newInput.split(",");
        return Arrays.stream(split).map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public LottoWinners match(Lottos lottos, List<Integer> pickLottoNumberOfWeek) {
        //매칭
        return lottos.check(pickLottoNumberOfWeek);
    }

    public double moneyProfitRate(int investMoney, LottoWinners winners) {
        return investMoney / (double) winners.totalMoney() * 100;
    }

    public void result() {
    }

}
