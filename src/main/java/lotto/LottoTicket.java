package lotto;

import java.util.List;
import java.util.ArrayList;

public class LottoTicket {

    private final int count;
    private final static int LOTTO_PRICE = 1000;
    private final List<LottoRow> lottoRowList = new ArrayList<>();

    public LottoTicket(int count) {
        this.count = count/LOTTO_PRICE;

        GenerateNumber generateNumber = new GenerateNumber();
        for (int i = 0; i < this.count; i++) {
            this.lottoRowList.add(new LottoRow(generateNumber.generateRandomNumbers()));
        }
    }

    public LottoTicket(List<LottoRow> rows) {
        this.count = rows.size();
        this.lottoRowList.addAll(rows);
    }

    public int getCount() {
        return count;
    }

    public List<LottoRow> getLottoRowList() {
        return lottoRowList;
    }
}
