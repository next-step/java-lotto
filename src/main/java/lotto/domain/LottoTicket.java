package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.utils.Validator.checkNotNull;

public class LottoTicket {

    private final List<LottoNumbers> lottoLines;

    public static LottoTicket publish(Dollars dollars, ShuffleStrategy shuffleStrategy) {
        checkNotNull(dollars);
        List<LottoNumbers> lottoLines = Stream.generate(() -> LottoNumbers.publish(shuffleStrategy))
                .limit(dollars.getCount())
                .collect(Collectors.toList());
        return new LottoTicket(lottoLines);
    }

    public LottoTicket(List<LottoNumbers> lottoLines) {
        checkNotNull(lottoLines);
        this.lottoLines = lottoLines;
    }

    public Statistics rank(LottoNumbers lastWinningNumbers, LottoNumber bonusNumber) {
        checkNotNull(lastWinningNumbers);
        List<Grade> grades = lottoLines.stream()
                .map(lottoLine -> lottoLine.rank(lastWinningNumbers, bonusNumber))
                .collect(Collectors.toList());
        return new Statistics(Grade.mapOf(grades), lineSizeToDollars());
    }

    private Dollars lineSizeToDollars() {
        return new Dollars(lottoLines.size() * Dollars.DOLLAR_UNIT);
    }

    public List<LottoNumbers> getLottoLines() {
        return Collections.unmodifiableList(lottoLines);
    }
}
