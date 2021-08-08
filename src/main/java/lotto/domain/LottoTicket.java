package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class LottoTicket {

    private final List<LottoNumbers> lottoNumbersList;

    private LottoTicket(List<LottoNumbers> lottoNumbersList) {
        this.lottoNumbersList = Objects.requireNonNull(lottoNumbersList);
    }

    public static LottoTicket of(List<LottoNumbers> lottoNumbersList) {
        return new LottoTicket(lottoNumbersList);
    }

    public void foreach(Consumer<LottoNumbers> action) {
        lottoNumbersList.forEach(action);
    }
}
