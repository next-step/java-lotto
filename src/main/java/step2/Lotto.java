package step2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lotto {

    private final List<Integer> lotto;

    public Lotto() {
        List<Integer> lottoList = IntStream.range(1, 45).boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoList);
        this.lotto = lottoList.stream()
                .limit(6)
                .sorted()
                .collect(Collectors.toList());
    }

    public Lotto(List<Integer> lotto){
        this.lotto = lotto;
    }

    public int matchWinningNumber(Lotto winningNumber){
        int winningCount = 0;
        for (int i : lotto) {
            winningCount += winningNumber.hasNumber(i);
        }
        return winningCount;
    }

    private int hasNumber(int number){
        if (lotto.contains(number)){
            return 1;
        }
        return 0;
    }

    public void printLotto(){
        System.out.println(lotto.toString());
    }


    @Override
    public String toString() {
        return lotto.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
