package lotto.domain.lotto;

import lotto.domain.rank.LottoRank;
import lotto.domain.rank.WinningLotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Lotto {
    private static final int MAX_SIZE = 5;

    private final List<LottoLine> lottoLines;

    Lotto(List<LottoLine> lottoLines) {
        validate(lottoLines);
        this.lottoLines = lottoLines;
    }

    public List<LottoRank> checkRank(WinningLotto winningLotto) {
        return lottoLines.stream()
                .map(lottoTicket -> lottoTicket.checkPrize(winningLotto))
                .collect(toList());
    }

    public List<List<Integer>> getLottoSources() {
        return lottoLines.stream()
                .map(LottoLine::toIntNumbers)
                .collect(Collectors.toList());
    }

    public int getMaxSize() {
        return lottoLines.size();
    }

    public List<LottoLine> getLottoLines() {
        return lottoLines;
    }

    private void validate(List<LottoLine> lottoLines) {
        if (lottoLines.size() > MAX_SIZE) {
            throw new LottoLineMaxSizeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto that = (Lotto) o;
        return Objects.equals(lottoLines, that.lottoLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoLines);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoLines=" + lottoLines.toString() +
                '}';
    }
}
