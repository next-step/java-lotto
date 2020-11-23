package lotto_auto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberManager {

    private static List<Integer> lottoNumberList =
            IntStream
                    .range(1, 45)
                    .boxed()
                    .collect(Collectors.toList());

    public static LottoNumbers generate() {
        Collections.shuffle(lottoNumberList);
        List<Integer> list = new ArrayList<>();
        list.addAll(lottoNumberList.subList(0, 6));
        Collections.sort(list);
        return new LottoNumbers(list);
    }
}
