package lotto.utils;

import lotto.dto.Lotto;
import lotto.vo.LottoNum;

import java.util.*;

public class LottoMaker {

    public static final int NUM_OF_CARDS = 45;
    public static final int NUM_OF_NUMBERS = 6;

    public static List<Integer> getOnetoFortyFive() {
        List<Integer> nums = new ArrayList<>();
        for( int i = 1 ; i <= NUM_OF_CARDS ; i ++ ){
            nums.add(i);
        }
        return nums;
    }

    public static List<Integer> getSixNumsAfterShuffle() {
        List<Integer> nums = getOnetoFortyFive();
        Collections.shuffle(nums);
        return nums.subList(0,NUM_OF_NUMBERS);
    }

    public static Lotto lottoOf(){
        List<Integer> lotto = getSixNumsAfterShuffle();
        Set<LottoNum> makedLotto = new HashSet<>();
        for (Integer integer : lotto){
            makedLotto.add(LottoNum.of(integer));
        }
        return new Lotto(makedLotto);
    }

    public static Lotto of(String arg){
        String[] temp = arg.split(",");
        Set<LottoNum> makedLotto = new HashSet<>();
        for(int i = 0 ; i < temp.length ; i++){
            makedLotto.add(LottoNum.of(Integer.parseInt(temp[i])));
        }

        return new Lotto(makedLotto);
    }



    public static String[] ofNewLine(String games) {
        return games.split("\n");
    }
}
