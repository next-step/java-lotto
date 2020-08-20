package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    public static List<Lotto> create(int lottoPurchaseCount) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i< lottoPurchaseCount; i++) {
            List<Integer> lottoNumbers = IntStream.range(0, 45)
                    .boxed()
                    .collect(Collectors.toList());
            Collections.shuffle(lottoNumbers);
            result.add(new Lotto(lottoNumbers));
        }
        return result;
    }

}
