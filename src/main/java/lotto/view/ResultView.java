package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.Reward;

import java.util.Arrays;
import java.util.List;

public class ResultView {

    public void printResult(Result result){
        for(int matchingCount : Reward.getRewardMap().keySet()){
            System.out.println(matchingCount + "개 일치 ("+ Reward.getReward(matchingCount) +"원)- "+ result.getWinCount(matchingCount) +"개");;
        }
    }

    public void printLottoNumber(List<Lotto> lottoList){
        for(Lotto lotto : lottoList){
            System.out.println(Arrays.toString(lotto.getNumbers()));
        }
    }

}