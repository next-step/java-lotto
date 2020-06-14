package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumbers implements LottoNumbers {

    List<Integer> totalNumberList = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toList());

    private static final int LOTTO_NUMBER = 6;

    @Override
    public List<LottoNo> generateNumbers() {

        long seed = System.nanoTime();
        Collections.shuffle(totalNumberList, new Random(seed));
        return totalNumberList.subList(0, LOTTO_NUMBER).stream()
                .map(integer -> new LottoNo(integer))
                .collect(Collectors.toList());
    }
}
