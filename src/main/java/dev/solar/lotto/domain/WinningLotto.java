package dev.solar.lotto.domain;

import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto {
    private final Set<LottoNumber> winningLotto;

    public WinningLotto(final Set<Integer> numbers) {
        this.winningLotto = numbers.stream().map(LottoNumber::new).collect(Collectors.toSet());
    }

    public int match(final LottoTicket lottoTicket) {
        return (int) winningLotto.stream().filter(lottoTicket.getLottoNumbers()::contains).count();
    }

}
