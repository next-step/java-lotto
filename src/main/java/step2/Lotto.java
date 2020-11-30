package step2;

import java.util.List;
import java.util.Objects;

public class Lotto {
    public final List<Integer> numberList;

    public Lotto(Generator lottoGenerator) {
        this.numberList = lottoGenerator.getLottoNumbers();
    }

    public int checkReward(List<Integer> result) {
        int winningNumber = 0;
        for (int i : result) {
            if (this.numberList.contains(i)) {
                winningNumber ++;
            }
        }
        return winningNumber;
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
