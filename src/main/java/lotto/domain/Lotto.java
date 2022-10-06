package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.shuffle;

public class Lotto {
    private final static int LOTTO_PRICE = 1000;
    private final static int LOTTO_SIZE = 6;
    private final static List<Integer> lottoNumbers = Arrays.asList(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45
    );

    public List<Set> lotto(int countOfLotto) {
        List<Set> issue = issue(countOfLotto);

        return issue;
    }

    private List<Set> issue(int countOfLotto) {
        return IntStream.range(0, countOfLotto)
                .mapToObj(i -> {
                    shuffle(lottoNumbers);
                    return new TreeSet<Integer>(lottoNumbers.stream()
                            .limit(LOTTO_SIZE)
                            .collect(Collectors.toList()));
                }).collect(Collectors.toUnmodifiableList());
    }
}
