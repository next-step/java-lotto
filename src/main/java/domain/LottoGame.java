package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LottoGame {

    public static final int TICKET_PRICE = 1000;
    private int tryNo;

    public LottoGame(LottoMoney lottoMoney, int manualBuyNumber) {
        if(lottoMoney.getTryNo() < manualBuyNumber) {
            throw new IllegalArgumentException("수동구매 갯수가 구입금액을 초과합니다.");
        }

        tryNo = lottoMoney.getTryNo() - manualBuyNumber;
    }

    public List<LottoSet> start() {
        List<LottoSet> lottoPaper = new ArrayList<>();

        while (isNotEnd()) {
            tryNo--;
            lottoPaper.add(round());
        }

        return Collections.unmodifiableList(lottoPaper);
    }

    private LottoSet round() {
        return LottoGenerator.getLottoSet();
    }

    private boolean isNotEnd() {
        return tryNo > 0;
    }
}
