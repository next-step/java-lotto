package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public void add(Lottos otherLottos){
        this.lottos.addAll(otherLottos.getLottos());
    }

    public List<Integer> countMatchingNumbers(WinningNumbers winningNumbers) {
        List<Integer> matchCountInfo = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int matched = winningNumbers.matchWinningNumber(lotto);
            matchCountInfo.add(matched);
        }
        return matchCountInfo;
    }

    public List<Boolean> matchingBonusNumbers(WinningNumbers winningNumbers) {
        List<Boolean> matchBonusNumberInfo = new ArrayList<>();
        for (Lotto lotto : lottos) {
            boolean matched = winningNumbers.matchBonusBall(lotto);
            matchBonusNumberInfo.add(matched);
        }
        return matchBonusNumberInfo;
    }

    public String showLottos() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.toString()).append("\n");
        }
        return sb.toString();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int count() {
        return lottos.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottos);
    }
}
