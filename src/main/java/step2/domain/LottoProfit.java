package step2.domain;

import java.util.Arrays;

public class LottoProfit {

    public double profit(int ticketMoney, LottoResult lottoResult) {
        return totalPrize(lottoResult) / ticketMoney;
    }

    private double totalPrize(LottoResult lottoResult) {

        return  Arrays.stream(LottoRank.values())
                .map(rank -> rank.reward()*lottoResult.countOfMatch(rank.countOfMatch()))
                .reduce(Integer::sum).orElse(0);

    }
}
