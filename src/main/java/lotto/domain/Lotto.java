package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> lotto;
    private final List<Integer> lottoNumberSet = IntStream.range(1, 45).boxed().collect(Collectors.toList());

    private int matchingCount = 0;
    private boolean isFirstWinner = false;
    private boolean isSecondWinner = false;
    private boolean isThirdWinner = false;
    private boolean isFourthWinner = false;
    private boolean isFifthWinner = false;

    public Lotto() {
        lotto = makeLotto();
    }

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    private List<Integer> makeLotto() {
        Collections.shuffle(lottoNumberSet);
        return lottoNumberSet.subList(0, 6).stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> lotto() {
        return lotto;
    }

    public boolean isFirstWinner() {
        return isFirstWinner;
    }

    public boolean isSecondWinner() {
        return isSecondWinner;
    }

    public boolean isThirdWinner() {
        return isThirdWinner;
    }

    public boolean isFourthWinner() {
        return isFourthWinner;
    }

    public boolean isFifthWinner() {
        return isFifthWinner;
    }

    public void checkWinning(Lotto winningLotto) {
        for (int number : winningLotto.lotto()) {
            if (lotto.contains(number)) {
                matchingCount++;
            }
        }
        switch (matchingCount){
            case 3:
                isFifthWinner = true;
                break;
            case 4:
                isFourthWinner = true;
                break;
            case 5:
                isThirdWinner = true;
                break;
            case 6:
                isFirstWinner = true;
        }
    }
}
