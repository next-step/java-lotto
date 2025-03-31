package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private final List<Lotto> lottoList;

    public LottoTicket(List<Lotto> lottoList) {
        validate(lottoList);
        this.lottoList = lottoList;
    }

    private void validate(List<Lotto> lottoList) {
        if (lottoList == null || lottoList.isEmpty()) {
            throw new IllegalArgumentException("로또가 지정되지 않았습니다.");
        }
    }

    public int count() {
        return lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

    public Summary summarize(WinningNumbers winningNumbers) {
        List<MatchCount> matchCounts = this.lottoList.stream()
                .map(it -> it.match(winningNumbers))
                .collect(Collectors.toUnmodifiableList());
        return new Summary(matchCounts);
    }
}
