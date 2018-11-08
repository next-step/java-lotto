package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int COMBINE_MAX_NUM = 6;
    private static final int COMBINE_MIN_NUM = 3;
    private static List<Lotto> combineLottos = new ArrayList<>();
    private static Lotto lastLotto;
    private static int[] combineNumbers = new int[COMBINE_MAX_NUM + 1];

    public LottoGame(List<Lotto> lottos, Lotto lastLotto) {
        combineLottos = lottos;
        this.lastLotto = lastLotto;
    }

    public List<Lotto> getCombineLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for(Lotto lotto : combineLottos ){
            int combineCount = lastLotto.getCombineCount(lotto);
            if(combineCount >= COMBINE_MIN_NUM) {
                lottos.add(lotto);
            }
        }
        combineLottos = lottos;
        return lottos;
    }


    public static int[] winCalculate(){
        for(Lotto lotto : combineLottos){
            combineNumbers[lotto.getCombineCount(lastLotto)]++;
        }
        return combineNumbers;
    }

    public static int winResult() {
        int result = 0;

        for(int i = COMBINE_MAX_NUM; COMBINE_MIN_NUM <= i ; i--){
            System.out.println(String.format("%s개 일치 (%s원)- %s개",i, LottoRank.findByCombineNum(i), combineNumbers[i]));
            result += LottoRank.findByCombineNum(i) * combineNumbers[i];
        }

        return result;
    }
}
