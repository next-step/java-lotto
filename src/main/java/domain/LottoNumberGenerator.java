package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;
    private static final int PICK = 6;

    public static List<LottoNumber> generateNumbers() {
        List<LottoNumber> candidate = IntStream
            .range(MINIMUM, MAXIMUM)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

        Collections.shuffle(candidate);

        List<LottoNumber> lottoNumbers = candidate.subList(0, PICK);
        Collections.sort(lottoNumbers);

        return Collections.unmodifiableList(lottoNumbers);
    }
}
