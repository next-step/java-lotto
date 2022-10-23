package lotto.core;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {

    private static final int MAX_SIZE = 6;
    private final List<Integer> lottoNums;

    public Lotto(LottoGenerateStrategy lottoGenerateStrategy) {
        this(lottoGenerateStrategy.generateLotto());
    }

    public Lotto(List<Integer> lottoNums) {
        if(lottoNums.size() > MAX_SIZE) {
            throw new IllegalArgumentException("lotto cannot have number quantity bigger than 6");
        }
        if(hasDuplicateNumbers(lottoNums)){
            throw new IllegalArgumentException("lotto cannot have duplicate numbers");
        }
        this.lottoNums = lottoNums;
    }

    public List<Integer> getLottoNums() {
        return lottoNums;
    }

    @Override
    public String toString() {
        return lottoNums.toString();
    }

    public int getCorrectCount(Lotto winningLottoNumbers){
        List<Integer> result = lottoNums.stream()
                .filter(old -> winningLottoNumbers.lottoNums.stream().anyMatch(Predicate.isEqual(old)))
                .collect(Collectors.toList());
        return result.size();
    }

    private final boolean hasDuplicateNumbers(List<Integer> integers){
        Set<Integer> tmpSet = new HashSet<>();

        Optional<Integer> duplicateNumber = integers.stream()
                .filter(integer -> !tmpSet.add(integer))
                .findAny();

        return duplicateNumber.isPresent();
    }
}
