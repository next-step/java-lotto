package lotto.domain;

import lotto.utils.LottoType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos;
    private Map<Integer, Integer> resultScore;
    private float totalRevenue;

    public Lottos(int inputTimes, LottoType lottoType) {

        lottos = new ArrayList<>();
        initResultScore();

        for (int i = 0; i < inputTimes; i++) {
            Lotto lotto = new Lotto(lottoType);
            lotto.makeLottoNumber();
            lottos.add(lotto);
        }

    }

    private void initResultScore() {
        resultScore = new HashMap();
        resultScore.put(3, 0);
        resultScore.put(4, 0);
        resultScore.put(5, 0);
        resultScore.put(6, 0);
    }

    public Map makeResultStatics(List lastWeekNumbers) {

        for (Lotto lotto : this.lottos) {

            int equalsCount = lotto.getEqualsCount(lastWeekNumbers);
            resultScoreValueAdd(equalsCount);
        }

        return resultScore;
    }

    private void resultScoreValueAdd(int equalsCount) {

        if (equalsCount >= 3) {
            int value = resultScore.get(equalsCount).intValue() + 1;
            resultScore.put(equalsCount, value);
        }

    }

    public List<String> getLottoNumbers() {
        return lottos.stream()
                .map(lotto -> lotto.getSelectedLottoNumbers())
                .collect(Collectors.toList());
    }

    public float getTotalRevenue(){
        float totalPrize = 0;
        for (Map.Entry<Integer, Integer> gameResult : resultScore.entrySet()) {
            String money = Prize.findByMoney(gameResult.getKey()).getMoney();
            int prize = Integer.parseInt(money);
            int count = gameResult.getValue();
            totalPrize += (prize * count);
        }

        float size = lottos.size();
        float totalBuy = size * 1000;
        this.totalRevenue = totalPrize / totalBuy;
        return totalRevenue;

    }

    public String getRevenueMention(){

        if(totalRevenue < 1){
            return "손해";
        }
        return "이득";
    }
}
