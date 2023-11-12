package lottoauto.domain.aggregate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShuffler implements CustomShuffle {

    @Override
    public List<Integer> makeShuffle() {
        List<Integer> lottoNumbers = IntStream.range(1, 46)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, 6);
    }
}
