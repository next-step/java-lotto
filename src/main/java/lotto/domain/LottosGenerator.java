package lotto.domain;

import java.util.List;

public class LottosGenerator {

    public static Lottos generate(Positive numberOfLottoNumber, List<String> manualNumbers) {
        Lottos lottos = generateLottos(manualNumbers);

        lottos.combineLottos(generateLottos(numberOfLottoNumber));

        return lottos;
    }
    private static Lottos generateLottos(Positive numberOfLottoNumber) {
        return new Lottos(numberOfLottoNumber);
    }

    private static Lottos generateLottos(List<String> manualNumbers) {
        return new Lottos(manualNumbers);
    }
}
