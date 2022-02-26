package lotto.domain.dto;

import java.util.List;
import lotto.domain.Lotto;

public class LottoCalculationDTO {

    private final int numberOfLottoManual;
    private final int numberOfLottoAutomatical;
    private final List<Lotto> lottos;

    public LottoCalculationDTO(int numberOfLottoManual, int numberOfLottoAutomatical,
        List<Lotto> lottos) {
        this.numberOfLottoManual = numberOfLottoManual;
        this.numberOfLottoAutomatical = numberOfLottoAutomatical;
        this.lottos = lottos;
    }

    public int getNumberOfLottoManual() {
        return numberOfLottoManual;
    }

    public int getNumberOfLottoAutomatical() {
        return numberOfLottoAutomatical;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
