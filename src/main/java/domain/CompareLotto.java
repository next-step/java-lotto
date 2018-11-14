package domain;

import java.util.ArrayList;
import java.util.List;

public class CompareLotto {
    static final int MATCHTHREE = 3;
    static final int MATCHFOUR = 4;
    static final int MATCHFIVE = 5;
    static final int MATCHSIX = 6;
    static int COUNTING = 0;

    private List<Integer> arrayOfLottoCheck;

    public List<Integer> getArrayOfLottoCheck() {
        return arrayOfLottoCheck;
    }

    public CompareLotto() {
        arrayOfLottoCheck = new ArrayList<>();

    }
    public void initCompareLotto() {
        for(int i = 0; i < 4; i++) {
            arrayOfLottoCheck.add(0);
        }
    }
    public void processingLotto(Lotto lotto, List<Integer> winningLotto) {
        for(List<Integer> oneOfLottoPapaer : lotto.lottoPapers()) {
            COUNTING = 0;
            compareLotto(winningLotto, oneOfLottoPapaer);
        }
    }

    private void compareLotto(List<Integer> result, List<Integer> list) {
        for(Integer i : list) {
            isMatched(result, i);
        }
    }

    private void isMatched(List<Integer> result,  Integer i) {
        if(result.contains(i)) {
            COUNTING++;
            threeMatch(COUNTING, this.arrayOfLottoCheck);
            fourMatch(COUNTING, this.arrayOfLottoCheck);
            fiveMatch(COUNTING, this.arrayOfLottoCheck);
            sixMatch(COUNTING, this.arrayOfLottoCheck);
        }
    }

    private static void threeMatch(int count, List<Integer> arrayOfLottoCheck) {
        if (count >= MATCHTHREE) {
            arrayOfLottoCheck.set(0, arrayOfLottoCheck.get(0) + 1);
        }
    }

    private static void fourMatch(int count, List<Integer> arrayOfLottoCheck) {
        if (count >= MATCHFOUR) {
            arrayOfLottoCheck.set(1, arrayOfLottoCheck.get(1) + 1);
        }
    }

    private static void fiveMatch(int count, List<Integer> arrayOfLottoCheck) {
        if (count >= MATCHFIVE) {
            arrayOfLottoCheck.set(2, arrayOfLottoCheck.get(2) + 1);
        }
    }

    private static void sixMatch(int count, List<Integer> arrayOfLottoCheck) {
        if (count == MATCHSIX) {
            arrayOfLottoCheck.set(3, arrayOfLottoCheck.get(3) + 1);
        }
    }

}
