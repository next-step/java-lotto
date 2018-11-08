package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int COMBINE_MAX_NUM = 6;
    private static final int COMBINE_MIN_NUM = 3;
    private static List<Lotto> combineLottos = new ArrayList<>();
    private static int[] combineNumbers = new int[COMBINE_MAX_NUM + 1];
    //Lotto끼리 글자수비교
    public static void getCombineCount(Lotto originLotto, Lotto lastLotto){
        List<Integer> numbers = originLotto.getNumbers();
        int combineCount = (int)numbers.stream()
                .filter(obj->lastLotto.getNumbers().contains(obj))
                .count();


        if(combineCount >= COMBINE_MIN_NUM){
            originLotto.setCombineCount(combineCount);
            combineLottos.add(originLotto);
        }
    }

    public static List<Lotto> getCombineLottos() {
        return combineLottos;
    }

    public static int[] getCombineNumbers() {
        return combineNumbers;
    }
    public static int[] winCalculate(){
        for(Lotto lotto : combineLottos){
            combineNumbers[lotto.getCombineCount()]++;
        }
        return combineNumbers;
    }

    public static int winResult() {
        LottoRank[] ranks = LottoRank.values();
        int result = 0;
        for(LottoRank rank : ranks){
            System.out.println(String.format("%s개 일치 (%s원)- %s개",rank.getCombineNum(), rank.getPriceRewards(), combineNumbers[rank.getCombineNum()]));
            result += (rank.getPriceRewards() * combineNumbers[rank.getCombineNum()]);
        }
        return result;
    }
}
