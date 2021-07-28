package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Lottos {

    private final List<LottoNumbers> lottoNumbers;

    public Lottos(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumbers> getLottos() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public static Lottos of(int money) {
        LottoTickets buy = LottoTickets.of(money);
        return new Lottos(buy.getLottoTickets());
    }

    public Stream<LottoResult> mapToResult(LottoBonus lottoBonus) {
        return lottoNumbers.stream()
                .map(lottoBonus::toResult);
    }
}
