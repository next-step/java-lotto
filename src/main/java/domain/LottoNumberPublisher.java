package domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberPublisher {
    private static final List<Integer> lottoNumbers = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toList());


    public static Set<Number> getShuffleSixLottoNumber() {
        Collections.shuffle(lottoNumbers);
        List<Integer> result = lottoNumbers.subList(0, 6);
        Collections.sort(result);
        return result.stream()
                .map(Number::new)
                .collect(Collectors.toSet());
    }
}
