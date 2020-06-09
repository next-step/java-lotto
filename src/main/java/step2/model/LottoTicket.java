package step2.model;

import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private final List<Lotto> lottos;

    private LottoTicket(List<Lotto> lottos) {
        if (lottos == null) {
            throw new IllegalArgumentException();
        }

        this.lottos = Collections.unmodifiableList(lottos);
    }

    public static LottoTicket create(List<Lotto> lottos) {
        return new LottoTicket(lottos);
    }

    public int getManualCount() {
        return (int) this.lottos.stream()
                .filter(Lotto::isManual)
                .count();
    }

    public int getAutoCount() {
        return (int) this.lottos.stream()
                .filter(Lotto::isAuto)
                .count();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public MatchResult calculateMatchResult(WinningNumbers winningNumbers) {
        MatchResult matchResult = MatchResult.create();

        this.lottos.stream()
                .map(winningNumbers::calculateMatchRank)
                .forEach(matchResult::plusCount);

        return matchResult;
    }
}
