package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    private final List<LottoNumber> lottoDefaultNumbers;

    public LottoMachine() {
        lottoDefaultNumbers = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            lottoDefaultNumbers.add(new LottoNumber(i + 1));
        }
    }

    public Lotto generateLotto() {
        Collections.shuffle(lottoDefaultNumbers);
        return new Lotto(
                lottoDefaultNumbers.stream()
                        .limit(7)
                        .collect(Collectors.toList())
        );
    }
}
