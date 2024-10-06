package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lotto {

    private final List<Integer> lotto;

    private Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public static Lotto create() {
        return new Lotto(generateLotto());
    }

    private static List<Integer> generateLotto() {
        List<Integer> lottoNumbers = IntStream.rangeClosed(1, 45)
                .boxed().collect(Collectors.toList());
        prepare(lottoNumbers);

        return Collections.unmodifiableList(lottoNumbers.subList(0, 6));
    }

    private static void prepare(List<Integer> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
        Collections.sort(lottoNumbers);
    }

    public Stream<Integer> stream() {
        return lotto.stream();
    }
}
