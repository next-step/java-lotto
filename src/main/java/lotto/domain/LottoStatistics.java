package lotto.domain;

import stringCalculator.domain.Arithmetic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    List<Integer> winningNumber = new ArrayList<>();

    static Map<Integer, Rank> rankCount = new HashMap<>();

    static {
        rankCount.put(6, Rank.FIRST);
        rankCount.put(5, Rank.SECOND);
        rankCount.put(4, Rank.THIRD);
        rankCount.put(3, Rank.FOURTH);
    }

    public LottoStatistics(){}

    public LottoStatistics(String winningNumber){
        saveWinningNumber(winningNumber);
    }
    private void saveWinningNumber(String winningNumber){
        for (String number : winningNumberArray(winningNumber)){
            this.winningNumber.add(Integer.valueOf(number));
        }
    }
    private String[] winningNumberArray(String winningNumber){
        if(!validationWinningNumber(winningNumber)){
            new Exception("입력값이 유효하지 않습니다.");
        };
        return winningNumber.split(",");
    }
    private Boolean validationWinningNumber(String winningNumber){
        return winningNumber.split(",").length == 6;
    }

    public int sameNumberQuantity(List<Integer> lottoNumber){
        int count = 0;
        for (int number : lottoNumber){
            count = count + sameNumberIncrease(number);
        }
        return count;
    }

    private int sameNumberIncrease(int number){
        if(this.winningNumber.contains(number)){
           return 1;
        };
        return 0;
    }

    public Float winningRank(List<List<Integer>>lottoNumber){
        addRankQuantity(lottoNumber);
        return  Float.valueOf(winningAmount()/(lottoNumber.size()*1000));
    }

     void addRankQuantity(List<List<Integer>> lottoNumber) {
        for (int i = 0; i < lottoNumber.size(); i++) {
            checkWinningRank(lottoNumber, i);
        }
    }
    int winningAmount(){
        int amount = 0;
        for (Rank rank : Rank.values()) {
            amount = amount + rank.getTotelMoney();
        }
        return amount;
    }
    private void checkWinningRank(List<List<Integer>> lottoNumber, int i) {
        if(sameNumberQuantity(lottoNumber.get(i)) >= 3){
            rankCount.get(sameNumberQuantity(lottoNumber.get(i))).addCount();
        }
    }


}
