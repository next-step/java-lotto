package lotto.domain;

import lotto.util.NumberUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLottos {
    Map<WinningLottoType,Integer> winningTypeCountMap;

    public WinningLottos(){
        winningTypeCountMap = new HashMap<>();
    }

    public WinningLottoType addMatchingNumber(WinningLottoType winningLottoType) {
        boolean isNotIncludLottoType = winningTypeCountMap.containsKey(winningLottoType) == false;
        if(isNotIncludLottoType) {
            winningTypeCountMap.put(winningLottoType,1);
            return winningLottoType;
        };
        winningTypeCountMap.put(winningLottoType, winningTypeCountMap.get(winningLottoType)+1);

        return winningLottoType;
    }

    public long amountOfWinning() {
        WinningLottoType[] winningLottoTypes = WinningLottoType.values();
        long winningLottoMoney = 0;
        for( int i = 0; i < winningLottoTypes.length ; i++ ){
            if(winningTypeCountMap.containsKey(winningLottoTypes[i])) {
                long typeMoney = winningLottoTypes[i].getWinnerMoney() * winningTypeCountMap.get(winningLottoTypes[i]);
                winningLottoMoney = winningLottoMoney + typeMoney;
            }
        }
        return winningLottoMoney;
    }

    public float calcurateRevenue(String money) {
        long inputMoney = NumberUtil.stringTolong(money);
        long winningMoney = this.amountOfWinning();
        if (winningMoney == 0) {
           return  0;
        }
        float revenue =  winningMoney / inputMoney;
        return revenue;
    }

    public Map<WinningLottoType,Integer> getWinningLottosMap(){
        return new HashMap<>(winningTypeCountMap);
    }
    public int getCountByWinningType( WinningLottoType winningLottoType){
        if(winningTypeCountMap.containsKey(winningLottoType) == false) {
            return 0;
        }
        return winningTypeCountMap.get(winningLottoType);
    }
}
