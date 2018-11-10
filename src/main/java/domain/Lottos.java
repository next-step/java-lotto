package domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static List<Lotto> lottoGroup;
    private static final int COMBINE_MIN_NUM = 3;
    private static final int COMBINE_MAX_NUM = 6;
    private static final int LOTTO_PRICE = 1000;
    private int[] combineNumbers;

    public Lottos(List<Lotto> lottoGroup) {
        if(lottoGroup == null){
            throw new NullPointerException();
        }
        if(lottoGroup.size() < 0){
            throw new IllegalArgumentException("배열이 없습니다.");
        }

        this.lottoGroup = lottoGroup;
    }

    public Lottos(int lottoCount){
        List<Lotto> lottos = new ArrayList<>();
        for(int i =0; i < lottoCount; i++){
            Lotto lotto = new Lotto();
            lottos.add(lotto);
            lotto.printLotto();
        }
        this.lottoGroup = lottos;
    }

    public int size() {
        return lottoGroup.size();
    }

    public static Lottos getCombineLottos(Lotto lastLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for(Lotto lotto : lottoGroup){
            int combineCount = lastLotto.getCombineCount(lotto);
            if(combineCount >= COMBINE_MIN_NUM){
                lottos.add(lotto);
            }
        }
        return new Lottos(lottos);
    }

    public static boolean isContain(Lotto lastLotto){
        return lottoGroup.stream().
                anyMatch(obj-> obj.equals(lastLotto));
    }

    public void calculateCombine(Lotto lastLotto) {
        int[] combineNumbers = new int[COMBINE_MAX_NUM +1];
        for(Lotto lotto : lottoGroup){
            combineNumbers[lotto.getCombineCount(lastLotto)]++;
        }
        this.combineNumbers =  combineNumbers;
    }

    public int getTotalRewards() {
        int totalRewards = 0;

        for(int combineNum = COMBINE_MAX_NUM; combineNum >= COMBINE_MIN_NUM ; combineNum--){
            printCombineCurrent(combineNum);
            printCombineCount(combineNumbers[combineNum]);
            totalRewards += getRewards(combineNumbers[combineNum], combineNum);
        }

        return totalRewards;
    }


    private static void printCombineCount(int lottoCount) {
        System.out.println(String.format("- %s개", lottoCount));
    }

    private static void printCombineCurrent(int combineCount) {
        System.out.print(String.format("%s개 일치 (%s원)",combineCount, LottoRank.findByCombineNum(combineCount)));
    }

    private static int getRewards(int lottoCount, int combineNum) {
        return LottoRank.findByCombineNum(combineNum) * lottoCount;
    }

    public static int getPrice(){
        return lottoGroup.size() * LOTTO_PRICE;
    }

}
