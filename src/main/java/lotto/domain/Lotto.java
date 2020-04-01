package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final Set<List<Integer>> lottoNumbers;

    public Lotto(int count) {
        lottoNumbers = new HashSet<>();

        for (int i = 0; i < count; i++) {
            List<Integer> set = NumberGenerator.generateOneSet();
            lottoNumbers.add(set);
        }
    }

    public Lotto(Set<List<Integer>> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableSet(lottoNumbers);
    }

    public int size() {
        return lottoNumbers.size();
    }

    public String toString(String format, String delimiter) {
        StringBuilder stringBuilder = new StringBuilder();

        for (List<Integer> oneSet : lottoNumbers) {
            String lottoNums = oneSet.stream().map(num -> Integer.toString(num)).collect(Collectors.joining(delimiter));
            stringBuilder.append(String.format(format, lottoNums));
        }

        return stringBuilder.toString();
    }
}
