package lotto.domain;

import java.util.List;

public class LottosGenerator {
    public static Lottos generate(Positive numberOfLottoNumber) {
        return new Lottos(numberOfLottoNumber);
    }

    public static Lottos generate(List<String> manualNumbers) {
        return new Lottos(manualNumbers);
    }
}
