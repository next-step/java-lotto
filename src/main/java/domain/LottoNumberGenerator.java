package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;
    private static final int PICK = 6;

    public static List<Integer> generateNumbers() {
        List<Integer> candidate = IntStream
            .range(MINIMUM, MAXIMUM)
            .boxed()
            .collect(Collectors.toList());

        Collections.shuffle(candidate);

        List<Integer> lottoNumbers = candidate.subList(0, PICK);
        Collections.sort(lottoNumbers);

        return Collections.unmodifiableList(lottoNumbers);
    }
}
