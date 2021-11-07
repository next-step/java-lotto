package lotto.domains;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private final List<Integer> lottoNumbers;

    public Lotto() {
        this.lottoNumbers = shuffledNumbers();
    }

    public List<Integer> lottoNumbers() {
        return lottoNumbers;
    }

    private List<Integer> shuffledNumbers() {
        List<Integer> totalLottoNumbers = totalLottoNumbers();
        Collections.shuffle(totalLottoNumbers);

        List<Integer> lottoShuffledNumbers = totalLottoNumbers.subList(0, 6);
        Collections.sort(lottoShuffledNumbers);

        return lottoShuffledNumbers;
    }

    private List<Integer> totalLottoNumbers() {
        return IntStream.range(0, 45)
                .mapToObj(i -> i + 1)
                .collect(Collectors.toList());
    }

    public int size() {
        return lottoNumbers.size();
    }

    public Integer number(int i) {
        if (i >= lottoNumbers.size()) {
            throw new IndexOutOfBoundsException();
        }

        return lottoNumbers.get(i);
    }
}
