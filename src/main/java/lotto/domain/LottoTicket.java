package lotto.domain;

import java.util.List;

public class LottoTicket {

    private static final String NOT_VALID_SIZE_EXCEPTION_MESSAGE = "[ERROR] 로또 티켓은 최소 1개 이상의 로또가 필요합니다.";

    private List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        validateLottos(lottos);
        this.lottos = lottos;
    }

    public int lottoCount() {
        return lottos.size();
    }

    private void validateLottos(List<Lotto> lottos) {
        if (lottoSizeInvalid(lottos)) {
            throw new IllegalArgumentException(NOT_VALID_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private boolean lottoSizeInvalid(List<Lotto> lottos) {
        return lottos == null || lottos.size() == 0;
    }
}
