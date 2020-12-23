package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WinningLottos {
    Map<WinningLottoType,Integer> winningTypeCountMap;

    public WinningLottos(){
        this.winningTypeCountMap = initWinningLottoTypeMap();
    }

    protected Map<WinningLottoType,Integer> initWinningLottoTypeMap(){
        Map<WinningLottoType,Integer> hashMap = new HashMap<>();
        WinningLottoType[] winningTypes = WinningLottoType.values();
        for( int i = 0; i < winningTypes.length; i++ ) {
            hashMap.put(winningTypes[i],0);
        }
        return hashMap;
    }

    public WinningLottoType addMatchingNumber(WinningLottoType winningLottoType) {
        winningTypeCountMap.put(winningLottoType, winningTypeCountMap.get(winningLottoType)+1);
        return winningLottoType;
    }

    public BigDecimal amountOfWinning() {
        WinningLottoType[] winningLottoTypes = WinningLottoType.values();
        BigDecimal winningLottoMoney = BigDecimal.ZERO;
        for( int i = 0; i < winningLottoTypes.length ; i++ ){
            if(winningTypeCountMap.containsKey(winningLottoTypes[i])) {
                long winnerMoney = winningLottoTypes[i].getWinnerMoney();
                Integer count = winningTypeCountMap.get(winningLottoTypes[i]);
                BigDecimal typeMoney = new BigDecimal(winnerMoney).multiply(new BigDecimal(count));
                winningLottoMoney = winningLottoMoney.add(typeMoney);
            }
        }
        return winningLottoMoney;
    }

    public BigDecimal calcurateRevenue(String money) {
        BigDecimal buyMoney = new BigDecimal(money);
        BigDecimal winningMoney = this.amountOfWinning();
        if (winningMoney == BigDecimal.ZERO) {
           return  BigDecimal.ZERO;
        }
        BigDecimal revenue = winningMoney.divide(buyMoney,2, RoundingMode.FLOOR);
        return revenue;
    }

    public Map<WinningLottoType, Integer> getWinningLottoTypeByCountMap(){
        return Collections.unmodifiableMap(this.winningTypeCountMap);
    }
}
