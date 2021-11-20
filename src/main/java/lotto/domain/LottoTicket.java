package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.utils.Validator.checkNotNull;

public class LottoTicket {

    // TODO: [2021/11/21 양동혁] final 추가
    private List<LottoNumbers> manualLottoLines = new ArrayList<>();
    private final List<LottoNumbers> lottoLines;

    public static LottoTicket publish(Dollars dollars, ShuffleStrategy shuffleStrategy) {
        checkNotNull(dollars);
        List<LottoNumbers> lottoLines = Stream.generate(() -> LottoNumbers.publish(shuffleStrategy))
                .limit(dollars.getCount())
                .collect(Collectors.toList());
        return new LottoTicket(lottoLines);
    }

    public static LottoTicket publish(PublishDetails publishDetails, ShuffleStrategy shuffleStrategy) {
        checkNotNull(publishDetails);
        List<LottoNumbers> lottoLines = Stream.generate(() -> LottoNumbers.publish(shuffleStrategy))
                .limit(publishDetails.autoLottoLineCount())
                .collect(Collectors.toList());
        return new LottoTicket(lottoLines, publishDetails.getManualLottoLines());
    }

    public LottoTicket(List<LottoNumbers> lottoLines) {
        checkNotNull(lottoLines);
        this.lottoLines = lottoLines;
    }

    public LottoTicket(List<LottoNumbers> lottoLines, List<LottoNumbers> manualLottoLines) {
        checkNotNull(lottoLines, manualLottoLines);
        this.lottoLines = lottoLines;
        this.manualLottoLines = manualLottoLines;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(manualLottoLines, that.manualLottoLines) && Objects.equals(lottoLines, that.lottoLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manualLottoLines, lottoLines);
    }
}
