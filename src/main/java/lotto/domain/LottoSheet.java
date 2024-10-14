package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoSheet {
    public static final int LOTTO_SHEET_PRICE = 1_000;
    private final LottoNumbers lottoNumbers;

    public LottoSheet() {
        this.lottoNumbers = LottoNumbers.generate();
    }

    public LottoSheet(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }

    public static int calculateSheetCount(int money) {
        return money / LOTTO_SHEET_PRICE;
    }

    public static List<LottoSheet> create(int lottoSheetCount) {
        List<LottoSheet> lottoSheets = new ArrayList<>();

        for (int i = 0; i < lottoSheetCount; i++) {
            lottoSheets.add(new LottoSheet());
        }

        return lottoSheets;
    }
}
