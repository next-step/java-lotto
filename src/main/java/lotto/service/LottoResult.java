package lotto.service;

import lotto.dto.Lotto;
import lotto.dto.LottoEnum;

import java.util.List;

public class LottoResult {

    public static final int STANDARD = 1;
    public static final String MINUS_PROFIT = "손해";
    public static final String PLUS_PROFIT = "이익";
    public static final String SAME_PROFIT = "본전";

    List<Lotto> lottos;
    List<Integer> winnerNums;
    int inputMoney;

    public LottoResult(List<Lotto> lottos, List<Integer> winnerNums, int inputMoney) {
        this.lottos = lottos;
        this.winnerNums = winnerNums;
        this.inputMoney = inputMoney;
    }

    public String matchCountResultString(List<Integer> winnersNum){
        StringBuilder sb = new StringBuilder();

        for(LottoEnum lEnum : LottoEnum.values()){
            sb.append(
                    String.format(
                            "%s개 일치 (%d원) - %d개\n"
                            ,lEnum.getMatch()
                            ,lEnum.getWon()
                            ,new LottoMatch(winnersNum).getMatchNum(lottos).get(lEnum.getMatch())
                    )
            );
        }

        sb.append(
                String.format(
                        "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 %s라는 의미임)"
                        ,getProfit(winnersNum)
                        ,getProfitMessage(getProfit(winnersNum))
                )
        );
        return sb.toString();
    }

    public static int duplicatedCounts(List<Integer> lotto , List<Integer> winnersNum){
        lotto.addAll(winnersNum);

        return 12 - (int) lotto.stream()
                .distinct()
                .count();
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

    public List<Integer> getWinnerNums() {
        return winnerNums;
    }

    public double getProfit(List<Integer> winnersNum){
        int sum = 0;
        for(LottoEnum lEnum : LottoEnum.values()){
            sum += new LottoMatch(winnersNum).getMatchNum(lottos).get(lEnum.getMatch()) * lEnum.getWon();
        }
        return sum/this.inputMoney;
    }
}
