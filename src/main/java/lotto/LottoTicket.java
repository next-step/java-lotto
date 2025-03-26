package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class LottoTicket {

    private final int count;
    private final List<LottoRow> lottoRowList = new ArrayList<>();

    public LottoTicket(int count) {
        this.count = count;

        for (int i = 0; i < count; i++) {
            GenerateNumber generateNumber = new GenerateNumber();
            this.lottoRowList.add(new LottoRow(generateNumber.generateRandomNumbers()));
        }
    }

    public int getCount() {
        return count;
    }
}
