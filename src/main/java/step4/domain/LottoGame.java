package step4.domain;

import step4.dto.ManualLottoNumberDTO;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final List<LottoNumbers> lottoNumbers = new ArrayList<>();

    private LottoGame() {
    }

    public static final LottoGame newInstance() {
        return new LottoGame();
    }

    public List<LottoNumbers> playLotto(final Ticket autoLottoTicket, List<ManualLottoNumberDTO> manualLottoNumbers) {
        final int ticketCount = autoLottoTicket.getCountOfTicket();
        playManualLotto(manualLottoNumbers);
        playAutoLotto(ticketCount);

        return lottoNumbers;
    }

    private void playAutoLotto(int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            lottoNumbers.add(LottoNumbers.from(LottoNumberGenerator
                    .generateAutoLottoNumber()));
        }
    }

    private void playManualLotto(List<ManualLottoNumberDTO> manualLottoNumbers) {
        for (ManualLottoNumberDTO manualLottoNumber : manualLottoNumbers) {
            lottoNumbers.add(LottoNumbers.from(
                    LottoNumberGenerator.generateManualLottoNumber(manualLottoNumber
                            .getManualLottoNumbers())));
        }
    }
}
