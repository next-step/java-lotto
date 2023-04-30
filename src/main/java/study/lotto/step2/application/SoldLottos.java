package study.lotto.step2.application;

import study.lotto.step2.domain.Lotto;

import java.util.List;
import java.util.Objects;

public class SoldLottos {
    private static final String LINE_BREAK = "\n";
    private final List<Lotto> lottos;

    public SoldLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public String selectedNumbers() {
        StringBuilder selectedNumbers = new StringBuilder();
        lottos.forEach(lotto -> {
            selectedNumbers.append(selectedNumberOf(lotto)).append(LINE_BREAK);
        });

        return selectedNumbers.toString();
    }

    private String selectedNumberOf(Lotto lotto) {
        return lotto.selectedNumbers().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SoldLottos)) return false;
        SoldLottos that = (SoldLottos) o;
        return Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
