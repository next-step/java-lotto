package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoRandomNumberUtils implements LottoRandomNumber {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final List<Integer> LOTTO_NUMBER_RANGE = IntStream.rangeClosed(1, 45)
                                                                        .boxed()
                                                                        .collect(Collectors.toList());

    public LottoNumber createRandomLotto() {
        List<Integer> randomNumber = new ArrayList<>();
        Collections.shuffle(LOTTO_NUMBER_RANGE);
        for (int number = 0; number < LOTTO_NUMBER_SIZE; number++) {
            randomNumber.add(LOTTO_NUMBER_RANGE.get(number));
        }
        Collections.sort(randomNumber);
        return new LottoNumber(randomNumber);
    }

    public static void validationNumber(List<Integer> lottoNumber) {
        Set<Integer> checkNumber = new HashSet<>(lottoNumber);
        if (checkNumber.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 숫자의 갯수는 6개 입니다");
        }
    }
}
