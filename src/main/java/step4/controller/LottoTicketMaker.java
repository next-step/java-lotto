package step4.controller;

import step4.domain.Amount;
import step4.domain.Lotto;
import step4.domain.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketMaker {
    private static final int LOTTO_TOTAL_COUNT = 6;

    private final int autoQty;

    private final Amount amount;

    private Lottos lottoTicket;

    private final int manualLottoQty;

    public LottoTicketMaker(int lottoAmount, int manualLottoQty, List<Lotto> manualLottoNumbers) {
        amount = Amount.of(lottoAmount);
        this.autoQty = lottoAutoPurchaseQty();
        this.manualLottoQty = manualLottoQty;
        lottoCreateStart(manualLottoNumbers);
    }

    public static LottoTicketMaker of(int lottoAmount, int manualLottoQty, List<Lotto> manualLottoNumbers) {
        return new LottoTicketMaker(lottoAmount, manualLottoQty, manualLottoNumbers);
    }

    public int lottoAutoPurchaseQty() {
        return amount.lottoPurchaseQty() - this.manualLottoQty;
    }

    private void lottoCreateStart(List<Lotto> lottos) {
        List<Lotto> lotto = IntStream.range(0, lottoAutoPurchaseQty())
                .mapToObj(i -> lottoTicketCreate())
                .collect(Collectors.toList());

        List<Lotto> result = new ArrayList<>();
        result.addAll(lottos);
        result.addAll(lotto);

        this.lottoTicket = new Lottos(result);
    }

    private Lotto lottoTicketCreate() {
        Lotto lotto = null;
        for (int j = 0; j < LOTTO_TOTAL_COUNT; j++) {
            lotto = new Lotto();
        }
        return lotto;
    }

    public Lottos getLottoTicket() {
        return this.lottoTicket;
    }
}
