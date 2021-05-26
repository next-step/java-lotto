package autolotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int MAX_LOTTO_RANGE = 45;
    private static final int SINGLE_LOTTO_DIGIT = 6;
    public static final int LOTTO_PRICE = 1000;
    private static List<Integer> lottoNumPool;
    private List<Integer> lottoNum;

    public Lotto() {
        if (this.lottoNumPool == null) {
            this.initLottoNum();
        }
        this.generateLottoNum();
    }

    public List<Integer> lottoNum() {
        return this.lottoNum;
    }

    public int countWin(int[] winList) {
        int winNum = 0;
        for (int i = 0; i < winList.length; i++) {
            winNum += this.getWinCount(winList[i]);
        }
        return winNum;
    }

    private int getWinCount(int targetNum) {
        if (this.isWinNumber(targetNum)) {
            return 1;
        }
        return 0;
    }

    private boolean isWinNumber(int targetNum) {
        if (this.lottoNum.contains(targetNum)) {
            return true;
        }
        return false;
    }

    private void initLottoNum() {
        this.lottoNumPool = new ArrayList<>();
        for (int i = 1; i <= MAX_LOTTO_RANGE; i++) {
            this.lottoNumPool.add(i);
        }
    }

    private void generateLottoNum() {
        Collections.shuffle(lottoNumPool);
        lottoNum = new ArrayList<>();
        for (int i = 0; i < SINGLE_LOTTO_DIGIT; i++) {
            lottoNum.add(lottoNumPool.get(i));
        }
    }
}
