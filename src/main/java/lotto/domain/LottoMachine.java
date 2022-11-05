package lotto.domain;

import lotto.util.AutoNumberMaker;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final AutoNumberMaker LOTTO_NUMBER_MAKER = new AutoNumberMaker();

    public static List<LottoNumbers> createLottoTickets(LottoCount lottoCount) {
        List<LottoNumbers> lottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoCount.getAutoLottoCount(); i++) {
            lottoTickets.add(new LottoNumbers(LOTTO_NUMBER_MAKER.getLottoNumbers()));
        }
        return lottoTickets;
    }

}
