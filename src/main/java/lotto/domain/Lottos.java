package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

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

    public IntStream mapToInt(LottoNumbers winLotto) {
        return lottoNumbers.stream()
                .mapToInt(s -> s.match(winLotto));
    }
}
