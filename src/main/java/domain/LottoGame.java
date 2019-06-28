package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    public static final int TICKET_PRICE = 1000;
    private int tryNo;

    public LottoGame(LottoMoney lottoMoney) {
        tryNo = lottoMoney.getTryNo();
    }

    public List<LottoSet> start() {
        List<LottoSet> lottoPaper = new ArrayList<>();

        while (isNotEnd()) {
            tryNo--;
            lottoPaper.add(round());
        }

        return Collections.unmodifiableList(lottoPaper);
    }

    public LottoSet round() {
        return LottoGenerator.getLottoSet();
    }

    private boolean isNotEnd() {
        return tryNo > 0;
    }


}