package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    private static final List<Integer> DEFAULT_NUMBERS = IntStream
            .rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toList());

    private static final int LOTTO_SIZE = 6;

    public static List<Integer> generateLotto() {
        Collections.shuffle(DEFAULT_NUMBERS);
        List<Integer> lottoNumbers = DEFAULT_NUMBERS.subList(0, LOTTO_SIZE);
        Collections.sort(lottoNumbers);
        return new ArrayList<>(lottoNumbers);
    }

    public static List<Lotto> generateLottos(int count) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new Lotto());
        }
        return list;
    }
}
