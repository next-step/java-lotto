package lotto.domain;

import lotto.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final int ZERO_INIT = 0;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 46;
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int REMOVE_INDEX = 0;

    public static List<Lotto> createLotto(int quantity) {
        int count = ZERO_INIT;
        List<Lotto> lottos = new ArrayList<>();
        while(count < quantity) {
            lottos.add(new Lotto(new LottoNumbers(generateLottoNumber().toArray(new Integer[0]))));
            count++;
        }
        return lottos;
    }

    public static List<Integer> generateLottoNumber() {
        List<Integer> baseNumbers = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER).forEach(i -> baseNumbers.add(i));
        for (int i = 0; i < LOTTO_NUMBER_SIZE; i++) {
            Collections.shuffle(baseNumbers);
            numbers.add(baseNumbers.remove(REMOVE_INDEX));
        }
        Collections.sort(numbers);

        return numbers;
    }
}
