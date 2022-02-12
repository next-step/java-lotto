package lotto.domain.dto;

import lotto.domain.Lottos;

public class LottoCalculationDTO {

    private final int numberOfLottoManual;
    private final int numberOfLottoAutomatical;
    private final Lottos lottos;

    public LottoCalculationDTO(int numberOfLottoManual, int numberOfLottoAutomatical, Lottos lottos) {
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

    public Lottos getLottos() {
        return lottos;
    }
}
