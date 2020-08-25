package lotto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int PRICE = 1000;
    private Set<LottoNumber> lotto;
    private int winningNumberCount;

    public Lotto(List<LottoNumber> lotto) {
        this.lotto = new HashSet<LottoNumber>(lotto);

        isValidSize();
    }

    private void isValidLotto(List<String> lotto) {
        Set<Integer> set = new HashSet<>();

    }

    private void isValidSize(){
        if(this.lotto.size() != 6) throw new IllegalArgumentException("Lotto must be contain unique 6 numbers");
    }

    @Override
    public String toString() {
        String lottoStr = lotto.stream()
                .map(i -> i.getNumberString())
                .collect(Collectors.joining(", "));

        return String.format("[%s]", lottoStr);
    }

    public int getSize(){
        return this.lotto.size();
    }

    private boolean isContainWinningNumber(LottoNumber winningNumber) {
       return lotto.contains(winningNumber);
    }

    public int countWinningNumber(LottoNumber winningNumber){
        if(isContainWinningNumber(winningNumber)){
            winningNumberCount++;
        }

        return winningNumberCount;
    }
}
