package lotto.domain;

import java.math.BigDecimal;
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

    public BigDecimal calcurateRevenue(String money) {
        BigDecimal buyMoney = new BigDecimal(money);
        BigDecimal winningMoney = BigDecimal.valueOf(this.amountOfWinning());
        if (winningMoney == BigDecimal.ZERO) {
           return  BigDecimal.ZERO;
        }
        BigDecimal revenue = winningMoney.divide(buyMoney);
        return revenue;
    }
    public Integer getWinningLottoTypeByCountMap(WinningLottoType winningLottoType){
        return this.winningTypeCountMap.get(winningLottoType);
    }

}
