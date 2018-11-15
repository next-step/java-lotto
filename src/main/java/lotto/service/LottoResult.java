package lotto.service;

import lotto.dto.Lotto;
import lotto.dto.Rank;
import lotto.dto.WinningLotto;

import java.util.List;
import java.util.Map;

public class LottoResult {

    public static final int STANDARD = 1;
    public static final String MINUS_PROFIT = "손해";
    public static final String PLUS_PROFIT = "이익";
    public static final String SAME_PROFIT = "본전";

    private List<Lotto> lottos;
    private WinningLotto winnerNums;
    private int inputMoney;

    public LottoResult(List<Lotto> lottos, WinningLotto winnerNums, int inputMoney) {
        this.lottos = lottos;
        this.winnerNums = winnerNums;
        this.inputMoney = inputMoney;
    }

    public String matchCountResultString(WinningLotto winnersNum){
        StringBuilder sb = new StringBuilder();
        Map<Rank, Integer> maps= new LottoMatch(winnersNum).getMatchNum(lottos);

        for(Rank rank : Rank.values()){
            if(rank == Rank.SECOND){
                sb.append(
                        String.format(
                                "%s개 일치, 보너스 볼 일치 (%d원) - %d개\n"
                                ,rank.getMatch()
                                ,rank.getWon()
                                ,maps.get(rank)
                        )
                );
                continue;
            }
            sb.append(
                    String.format(
                            "%s개 일치 (%d원) - %d개\n"
                            ,rank.getMatch()
                            ,rank.getWon()
                            ,maps.get(rank)
                    )
            );
        }

        sb.append(
                String.format(
                        "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 %s라는 의미임)"
                        ,getProfit(maps)
                        ,getProfitMessage(getProfit(maps))
                )
        );
        return sb.toString();
    }

    public String getProfitMessage(double res){
        if(isLow(res)){
            return MINUS_PROFIT;
        }
        if(isGreater(res)){
            return PLUS_PROFIT;
        }
        return SAME_PROFIT;
    }

    private boolean isLow(double res) {
        return res < STANDARD;
    }

    private boolean isGreater(double res) {
        return res > STANDARD;
    }

    public WinningLotto getWinnerNums() {
        return winnerNums;
    }

    public double getProfit(Map<Rank, Integer> maps){
        int sum = 0;
        for(Rank rank : Rank.values()){
            sum += maps.get(rank) * rank.getWon();
        }
        return sum/this.inputMoney;
    }
}
