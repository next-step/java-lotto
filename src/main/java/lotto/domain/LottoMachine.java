package lotto.domain;

import lotto.util.LottoNumberMaker;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final LottoNumberMaker LOTTO_NUMBER_MAKER = new LottoNumberMaker();

    public static List<LottoNumbers> createLottoTickets(LottoCount lottoCount) {
        List<LottoNumbers> lottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoCount.getCount(); i++) {
            lottoTickets.add(new LottoNumbers(LOTTO_NUMBER_MAKER.getLottoNumbers()));
        }
        return lottoTickets;
    }

}
