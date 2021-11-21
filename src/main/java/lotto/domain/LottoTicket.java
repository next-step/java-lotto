package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableList;
import static lotto.utils.Validator.checkNotNull;

public class LottoTicket {

    private final List<LottoNumbers> manualLottoLines;
    // TODO: [2021/11/21 양동혁] autoLottoLines으로 변경
    private final List<LottoNumbers> lottoLines;

    public static LottoTicket publish(PublishDetails publishDetails, ShuffleStrategy shuffleStrategy) {
        checkNotNull(publishDetails);
        List<LottoNumbers> autoLottoLines = createLottoLines(publishDetails.autoLottoLineCount(), shuffleStrategy);
        return new LottoTicket(autoLottoLines, publishDetails.manualLottoLines());
    }

    private static List<LottoNumbers> createLottoLines(int lineCount, ShuffleStrategy shuffleStrategy) {
        return Stream.generate(() -> LottoNumbers.publish(shuffleStrategy))
                .limit(lineCount)
                .collect(Collectors.toList());
    }

    public LottoTicket(List<LottoNumbers> lottoLines, List<LottoNumbers> manualLottoLines) {
        checkNotNull(lottoLines, manualLottoLines);
        this.lottoLines = lottoLines;
        this.manualLottoLines = manualLottoLines;
    }

    public Statistics rank(LottoNumbers lastWinningNumbers, LottoNumber bonusNumber) {
        checkNotNull(lastWinningNumbers);
        List<Grade> grades = allLottoLines().stream()
                .map(lottoLine -> lottoLine.rank(lastWinningNumbers, bonusNumber))
                .collect(Collectors.toList());
        return new Statistics(Grade.mapOf(grades), allLineSizeToDollars());
    }

    private Dollars allLineSizeToDollars() {
        return new Dollars(allLottoLines().size() * Dollars.DOLLAR_UNIT);
    }

    public List<LottoNumbers> allLottoLines() {
        List<LottoNumbers> allLottoLines = new ArrayList<>();
        allLottoLines.addAll(manualLottoLines);
        allLottoLines.addAll(lottoLines);
        return unmodifiableList(allLottoLines);
    }

    public int manualLottoLinesCount() {
        return manualLottoLines.size();
    }

    public int autoLottoLinesCount() {
        return lottoLines.size();
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
