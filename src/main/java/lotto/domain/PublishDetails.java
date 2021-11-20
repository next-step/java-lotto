package lotto.domain;

import java.util.List;

import static java.util.Collections.unmodifiableList;
import static lotto.utils.Validator.checkNotNull;

public class PublishDetails {

    private final Dollars dollars;
    private final List<LottoNumbers> manualLottoLines;

    public PublishDetails(Dollars dollars, List<LottoNumbers> manualLottoLines) {
        checkArguments(dollars, manualLottoLines);
        this.dollars = dollars;
        this.manualLottoLines = manualLottoLines;
    }

    private void checkArguments(Dollars dollars, List<LottoNumbers> manualLottoLines) {
        checkNotNull(dollars, manualLottoLines);
        dollars.checkEnoughMoney(manualLottoLines);
    }

    public int autoLottoLineCount() {
        return dollars.getCount() - manualLottoLines.size();
    }

    public List<LottoNumbers> manualLottoLines() {
        return unmodifiableList(manualLottoLines);
    }

    @Override
    public String toString() {
        return "PublishDetails{" +
                "dollars=" + dollars +
                ", manualLottoLines=" + manualLottoLines +
                '}';
    }
}
