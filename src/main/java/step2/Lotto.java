package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> LOTTO_NUMBER_VALUES = IntStream.range(1, 46)
            .boxed()
            .sorted()
            .collect(Collectors
                    .toList());

    private List<Integer> lottoNumber = new ArrayList<>();

    public Lotto() {
        lottoNumber.addAll(LOTTO_NUMBER_VALUES);
        shuffleLottoNumbers(lottoNumber);
    }

    private void shuffleLottoNumbers(List<Integer> lottoNumber) {
        Collections.shuffle(lottoNumber);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "LOTTO_NUMBER_VALUES=" + LOTTO_NUMBER_VALUES +
                ", lottoNumber=" + lottoNumber +
                '}';
    }
}
