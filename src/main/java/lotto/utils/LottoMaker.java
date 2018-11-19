package lotto.utils;

import lotto.dto.Lotto;

import java.util.*;

public class LottoMaker {

    private static final int NUM_OF_CARDS = 45;
    private static final int NUM_OF_NUMBERS = 6;

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
        Set<Integer> makedLotto = new HashSet<>();
        for (Integer integer : lotto){
            makedLotto.add(integer);
        }
        return new Lotto(makedLotto);
    }

    public static Lotto of(String arg){
        String[] temp = arg.split(",");
        Set<Integer> makedLotto = new HashSet<>();
        for(int i = 0 ; i < temp.length ; i++){
            makedLotto.add(Integer.parseInt(temp[i].trim()));
        }

        return new Lotto(makedLotto);
    }

    public static Set<Lotto> ofNewLine(String games) {
        String[] bindedGames = games.split("\n");
        Set<Lotto> manualLottos = new HashSet<>();
        for( int i = 0 ; i < bindedGames.length ; i++ ){
            manualLottos.add(of(bindedGames[i]));
        }

        return manualLottos;

    }
}
