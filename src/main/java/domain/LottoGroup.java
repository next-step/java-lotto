package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {
    public static final int COMBINE_MIN_NUM = 3;
    public static final int COMBINE_MAX_NUM = 6;

    private List<Lotto> lottoGroup;
    private int[] combineNumbers;

    public LottoGroup(List<Lotto> lottoGroup) {
        if (lottoGroup == null) {
            throw new NullPointerException();
        }
        if (lottoGroup.size() < 0) {
            throw new IllegalArgumentException("배열이 없습니다.");
        }

        this.lottoGroup = lottoGroup;
    }

    public LottoGroup(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
        this.lottoGroup = lottos;
    }

    public List<Lotto> getLottoGroup() {
        return lottoGroup;
    }

    public int getCombineNumbers(int combineNum) {
        return combineNumbers[combineNum];
    }

    public int getSize() {
        return lottoGroup.size();
    }

    public boolean isContain(Lotto lastLotto) {
        return lottoGroup.stream().
                anyMatch(obj -> obj.equals(lastLotto));
    }

    public int[] calculateCombine(Lotto lastLotto) {
        int[] combineNumbers = new int[COMBINE_MAX_NUM + 1];
        for (Lotto lotto : lottoGroup) {
            combineNumbers[lotto.getCombineCount(lastLotto)]++;
        }
        this.combineNumbers = combineNumbers;
        return combineNumbers;
    }

    public int getTotalRewards() {
        int totalRewards = 0;

        for (int combineNum = COMBINE_MAX_NUM; combineNum >= COMBINE_MIN_NUM; combineNum--) {
            totalRewards += getRewards(combineNumbers[combineNum], combineNum);
        }

        return totalRewards;
    }

    private static int getRewards(int lottoCount, int combineNum) {
        return LottoRank.findByCombineNum(combineNum) * lottoCount;
    }
}
