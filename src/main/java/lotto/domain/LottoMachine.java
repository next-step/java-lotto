package lotto.domain;

import lotto.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {
    public static List<Lotto> createLotto(int quantity) {
        int count = 0;
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
        IntStream.range(1, 46).forEach(i -> baseNumbers.add(i));
        for (int i = 0; i < 6; i++) {
            Collections.shuffle(baseNumbers);
            numbers.add(baseNumbers.remove(0));
        }
        Collections.sort(numbers);

        return numbers;
    }
}
