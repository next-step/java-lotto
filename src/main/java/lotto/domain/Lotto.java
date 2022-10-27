package lotto.domain;

import lotto.strategy.LottoGenerateStrategy;

import java.util.Set;
import java.util.TreeSet;

public class Lotto {

    private static final int DEFAULT_SIZE = 6;


    private final Set<Integer> lottoNums;

    public Lotto(LottoGenerateStrategy lottoGenerateStrategy){
        this(lottoGenerateStrategy.generateLotto());
    }

    public Lotto(Set<Integer> lottoNums) {
        if(lottoNums.size() != DEFAULT_SIZE) {
            throw new IllegalArgumentException("lotto input has wrong size");
        }
        this.lottoNums = new TreeSet<>(lottoNums);
    }

    public boolean hasSameElement(Integer number){
        return lottoNums.contains(number);
    }

    public Set<Integer> getLottoNums() {
        return lottoNums;
    }

    @Override
    public String toString() {
        return lottoNums.toString();
    }

    public int getSameElementsSize(Lotto winningLottoNumbers){
        return (int) lottoNums.stream()
                .filter(winningLottoNumbers::hasSameElement)
                .count();
    }
}
