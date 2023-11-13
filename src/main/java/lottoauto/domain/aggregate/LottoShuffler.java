package lottoauto.domain.aggregate;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShuffler implements CustomShuffle {

    private final List<Integer> defaultLottoNumbers =  IntStream.range(1, 46)
            .boxed()
            .collect(Collectors.toList());

    @Override
    public List<Integer> makeShuffle() {
        Collections.shuffle(defaultLottoNumbers, new Random(System.currentTimeMillis()));
        System.out.println(defaultLottoNumbers);
        return defaultLottoNumbers.stream().limit(6).collect(Collectors.toList());
    }
}
