package step2.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private LottoGenerator() {
    }

    // 로또 발급하기
    public static List<List<Integer>> generateTotalLotto(int countOfLotto) {
        return IntStream.range(0, countOfLotto)
                .mapToObj(i -> LottoGenerator.generateLotto())
                .collect(Collectors.toList());
    }

    // 로또 번호 생성하기
    private static List<Integer> generateLotto() {
        List<Integer> lotto = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(lotto);
        return lotto.subList(0, 6);
    }
}
