package step2.service;

import step2.domain.LottoWinners;
import step2.domain.Lottos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGameService {

    public List<Integer> pickLottoNumberOfWeek(String input) {
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException("로또 당첨번호가 비어있습니다");

        String newInput = input.replace(" ", "");
        String[] split = newInput.split(",");
        List<Integer> result = Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (result.size() != 6)
            throw new IllegalArgumentException("로또 당첨번호는 6개이다");

        if (result.size() != result.stream().distinct().count())
            throw new IllegalArgumentException("로또 당첨번호는 유니크 합니다");

        return result;
    }

    public LottoWinners match(Lottos lottos, List<Integer> pickLottoNumberOfWeek) {
        //매칭
        return lottos.check(pickLottoNumberOfWeek);
    }

    public double moneyProfitRate(int investMoney, LottoWinners winners) {
        return winners.totalMoney() / (double) investMoney;
    }
}
