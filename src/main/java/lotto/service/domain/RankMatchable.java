package lotto.service.domain;

import lotto.service.domain.types.Rank;

public interface RankMatchable {
    Rank matchRank(LottoTicket lottoTicket);
}
