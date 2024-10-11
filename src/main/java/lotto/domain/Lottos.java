package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public static Lottos create(int lottoCount, LottoNumbersGenerater numbersGenerater){
        List<Lotto> lottos = new ArrayList<Lotto>();
        for(int i = 0; i < lottoCount; i++){
            lottos.add(Lotto.create(numbersGenerater));
        }
        return new Lottos(lottos);
    }

    public List<Integer> countMatchingNumbers(WinningNumbers winningNumbers) {
        List<Integer> matchCountInfo = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int matched = winningNumbers.matchWinningNumber(lotto);
            matchCountInfo.add(matched);
        }
        return matchCountInfo;
    }

    public String showLottos() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.toString()).append("\n");
        }
        return sb.toString();
    }

    public int count() {
        return lottos.size();
    }

}
