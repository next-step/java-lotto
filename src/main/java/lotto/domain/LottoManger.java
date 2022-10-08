package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.strategy.ExtractStrategy;

public class LottoManger {

    private final int WIN_NUMBER = 6;

    private final List<Lotto> lottos = new ArrayList<>();

    public LottoManger(int lottoNums, ExtractStrategy extractStrategy) {
        for (int i = 0; i < lottoNums; i++) {
            List<Integer> winNumber = extractStrategy.extractNumber(WIN_NUMBER);
            lottos.add(new Lotto(winNumber));
        }
    }

    public List<Lotto> retrieveLottos() {
        return lottos;
    }

    public List<Integer> retrieveWinNums(List<Integer> correctNumbers) {
        List<Integer> winNums = new ArrayList<>();
        for (Lotto lotto : lottos) {
            winNums.add(lotto.retrieveCorrectNum(correctNumbers));
        }
        return winNums;
    }
}
