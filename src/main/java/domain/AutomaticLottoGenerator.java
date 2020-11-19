package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutomaticLottoGenerator {

    static final List<Integer> oneToFortyFive = IntStream.rangeClosed(1,45).boxed().collect(Collectors.toList());

    public static Lottos generate(int numberOfLottos) {
        List<Lotto> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            Collections.shuffle(oneToFortyFive);
            lottoNumbers.add(Lotto.of(oneToFortyFive.stream()
                                        .limit(6)
                                        .sorted()
                                        .collect(Collectors.toList())));
        }

        return new Lottos(lottoNumbers);
    }

}
