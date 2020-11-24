package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final List<Integer> oneToFortyFive = IntStream.rangeClosed(1,45).boxed().collect(Collectors.toList());

    public static List<Lotto> generate(int numberOfLottos) throws Exception {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            Collections.shuffle(oneToFortyFive);
            lottos.add(Lotto.of(oneToFortyFive.stream()
                                        .limit(Lotto.LOTTO_NUMBERS_SIZE)
                                        .sorted()
                                        .collect(Collectors.toList())));
        }

        return lottos;
    }

    public static List<Lotto> generate(List<List<Integer>> lottoNumbers) throws Exception {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoNumbers.size(); i++) {
            lottos.add(Lotto.of(lottoNumbers.get(i)));
        }

        return lottos;
    }

}
