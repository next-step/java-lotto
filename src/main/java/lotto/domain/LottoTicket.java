package lotto.domain;

import lotto.dto.LottoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket(int lottoCount) {
        this.lottos = create(lottoCount);
    }

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Lotto> create(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    public List<LottoDto> generateTickets() {
        return lottos.stream().map(LottoDto::new).collect(Collectors.toList());
    }

    public LottoWinning result(Lotto winningLotto) {
        LottoWinning winning = new LottoWinning();
        for (Lotto ticket : lottos) {
            winning.put(LottoRank.win(winningLotto.matches(ticket)));
        }
        return winning;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
