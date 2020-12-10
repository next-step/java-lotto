package autolotto.model;

import java.util.HashMap;

public class LottosComparer {

    private final HashMap<Integer,Integer> matchingNumbers= new HashMap<Integer, Integer>() {
        {
            for (int i = 3; i < 7; i++) {
                put(i,0);
            }
        }
    };

    private int matchingCount;

    public LottosComparer(Lottos lottos, Lotto lotto) {
        for (int i = 0; i < lottos.getLottosCount(); i++) {
            compareLotto(lottos.getLotto(i),lotto);
        }
    }

    public int getMatchingCount(int matchingNumber) {
        return matchingNumbers.get(matchingNumber);
    }

    private void compareLotto(Lotto lotto, Lotto winningNumbers) {
        for (int i = 0; i < 6; i++) {
            checkMatchingNumber(lotto.getNumber(i), winningNumbers);
        }

        if (3 < matchingCount && matchingCount < 7) {
            matchingNumbers.put(matchingCount, matchingNumbers.get(matchingCount) + 1);
        }

        matchingCount = 0;
    }

    private void checkMatchingNumber(int lottoNumber, Lotto winningNumber) {

        for (int i = 0; i < 6; i++) {
            compareNumber(lottoNumber, winningNumber.getNumber(i));
        }
    }

    private void compareNumber(int lottoNumber, int winningNumber) {
        if (winningNumber == lottoNumber) {
            matchingCount++;
        }
    }

}
