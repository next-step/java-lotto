package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static List<LottoNumber> numbers = generateNumber();

    public List<Lotto> autoPublish(int buyingCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < buyingCount; i++) {
            lottos.add(pickNumber());
        }
        return lottos;
    }

    private static List<LottoNumber> generateNumber() {
        numbers = new ArrayList<>();

        for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }

    private Lotto pickNumber() {
        Collections.shuffle(numbers);
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < Lotto.PICK_COUNT; i++) {
            lottoNumbers.add(numbers.get(i));
        }
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }
}
