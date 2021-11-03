package lotto.domains;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = getShuffledLottoNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> getShuffledLottoNumbers() {
        List<Integer> lottoNumbers = getLottoNumbers();
        Collections.shuffle(lottoNumbers);

        List<Integer> lottoShuffledNumbers = lottoNumbers.subList(0, 6);
        Collections.sort(lottoShuffledNumbers);

        return lottoShuffledNumbers;
    }

    private List<Integer> getLottoNumbers() {
        return IntStream.range(0, 45)
                .mapToObj(i -> i + 1)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }

}
