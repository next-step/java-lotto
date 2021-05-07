package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum SameCount{
    COUNT_THREE("3개 일치"),
    COUNT_FOUR("4개 일치"),
    COUNT_FIVE("5개 일치"),
    COUNT_FIVE_BONUS("5개 일치, 보너스볼 일치"),
    COUNT_SIX("6개 일치");

    private String sameCountValue;
    SameCount(String sameCountValue){
        this.sameCountValue = sameCountValue;
    }

    public String getSameCount(){
        return sameCountValue;
    }
}

public class WinningNumber {

    Lotto lotto = new Lotto();

    public void grade(List<Integer> lottoNumbers,List<Integer> winningNumber){
        int containCount = 0;
        List<Boolean> containNumber = isContain(lottoNumbers, winningNumber);

        Map<Boolean, Integer> map = new HashMap<Boolean, Integer>();
        for(boolean trueCount : containNumber) {
            map.put(trueCount, map.getOrDefault(trueCount, 0)+1);
        }
        System.out.println(map);
    }

    public List<Boolean> isContain(List<Integer> lottoNumbers,List<Integer> winningNumber){
        List<Boolean> containNumber = new ArrayList<>();

        for(int i = 0; i < lottoNumbers.size(); i++){
            containNumber.add(lottoNumbers.contains(winningNumber.get(i)));
        }

        return containNumber;
    }
}


