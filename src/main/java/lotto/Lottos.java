package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

public class Lottos {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final List<Integer> NUMBERS = rangeClosed(MIN, MAX).boxed().collect(toList());

    private final List<Lotto> values;

    public Lottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            Lotto lotto = new Lotto(pickLottoNumbers());
            lottos.add(lotto);
        }

        this.values = lottos;
    }

    private LottoNumbers pickLottoNumbers() {
        Collections.shuffle(NUMBERS);

        List<LottoNumber> pickedNumbers = NUMBERS.stream()
                .limit(6)
                .sorted()
                .map(LottoNumber::new)
                .collect(toList());

        return new LottoNumbers(pickedNumbers);
    }

    public List<Lotto> getValues() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos = (Lottos) o;
        return Objects.equals(values, lottos.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "Lottos{" +
                "values=" + values +
                '}';
    }
}
