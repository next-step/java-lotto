package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LottoMachine {

    private final List<LottoNumber> lottoDefaultNumbers;
    private final Random random = new Random();

    public LottoMachine() {
        lottoDefaultNumbers = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            lottoDefaultNumbers.add(new LottoNumber(i + 1));
        }
    }

    public Lottos purchaseLotto(int purchaseNumber) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseNumber; i++) {
            lottos.add(generateLotto());
        }
        return new Lottos(lottos);

    }

    public Lotto generateLotto() {
        Collections.shuffle(lottoDefaultNumbers, random);
        return new Lotto(
                lottoDefaultNumbers.stream()
                        .limit(6)
                        .collect(Collectors.toList())
        );
    }
}
