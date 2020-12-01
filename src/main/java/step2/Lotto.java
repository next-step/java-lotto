package step2;

import java.util.List;
import java.util.Objects;

public class Lotto {
    public final List<Integer> numberList;
    private int winningCnt = 0;

    public Lotto(Generator lottoGenerator) {
        this.numberList = lottoGenerator.getLottoNumbers();
    }

    public void checkReward(List<Integer> result) {
        int winningNumber = 0;
        for (int i : result) {
            if (this.numberList.contains(i)) {
                winningNumber ++;
            }
        }
        this.winningCnt = winningNumber;
    }

    public int getWinningCnt(){
        return this.winningCnt;
    }
    public List<Integer> getNumberList(){
        return numberList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numberList, lotto.numberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberList);
    }
}
