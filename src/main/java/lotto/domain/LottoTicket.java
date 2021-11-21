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
    private final List<LottoNumbers> autoLottoLines;

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

    public LottoTicket(List<LottoNumbers> autoLottoLines, List<LottoNumbers> manualLottoLines) {
        checkNotNull(autoLottoLines, manualLottoLines);
        this.autoLottoLines = autoLottoLines;
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
        allLottoLines.addAll(autoLottoLines);
        return unmodifiableList(allLottoLines);
    }

    public int manualLottoLinesCount() {
        return manualLottoLines.size();
    }

    public int autoLottoLinesCount() {
        return autoLottoLines.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(manualLottoLines, that.manualLottoLines) && Objects.equals(autoLottoLines, that.autoLottoLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manualLottoLines, autoLottoLines);
    }
}
