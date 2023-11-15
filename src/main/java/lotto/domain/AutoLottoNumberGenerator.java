package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoNumberGenerator implements LottoNumberGenerator {
    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 6;
    private List<Integer> numbers = new ArrayList<>();

    public AutoLottoNumberGenerator() {
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
    }

    @Override
    public List<Lotto> generate(int amount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            Collections.shuffle(numbers);
            LottoNumbers lottoNumbers = convertToLottoNumbers(numbers.subList(FROM_INDEX, TO_INDEX));
            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }

    private static LottoNumbers convertToLottoNumbers(List<Integer> numbers) {
        LottoNumbers lottoNumbers = new LottoNumbers();
        for (int n : numbers) {
            lottoNumbers.add(new LottoNumber(n));
        }
        return lottoNumbers;
    }
}
