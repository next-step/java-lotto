package step4.controller;

import step4.domain.Amount;
import step4.domain.Lotto;
import step4.domain.Lottos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketMaker {
    private static final int LOTTO_TOTAL_COUNT = 6;

    private final Amount amount;

    private final int autoQty;

    private Lottos lottoTicket;

    private final int manualLottoQty;

    private LottoTicketMaker(int manualLottoQty, Amount amount, String lottoNumber) {
        this.amount = amount;
        this.manualLottoQty = manualLottoQty;
        this.autoQty = lottoAutoPurchaseQty();

        run(manualLottoQty, lottoNumber);
    }

    private void run(int manualLottoQty, String lottoNumber) {
        List<Lotto> lottos = askManualLottoNumbers(manualLottoQty, lottoNumber);
        this.lottoTicket = create(lottos);
    }

    public static LottoTicketMaker of(Amount amount, int manualLottoQty, String lottos) {
        return new LottoTicketMaker(manualLottoQty, amount, lottos);
    }

    public int lottoAutoPurchaseQty() {
        return amount.lottoPurchaseQty() - this.manualLottoQty;
    }

    private Lottos create(List<Lotto> lottos) {
        List<Lotto> result = new ArrayList<>();
        List<Lotto> lotto = IntStream.range(0, lottoAutoPurchaseQty())
                .mapToObj(i -> lottoTicketCreate())
                .collect(Collectors.toList());

        result.addAll(lottos);
        result.addAll(lotto);

        return new Lottos(result);
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

    private List<Lotto> askManualLottoNumbers(int numberOfManualLottos, String manualLottoNumber) {
        return IntStream.range(0, numberOfManualLottos)
                .mapToObj(i -> setManualLottoNumbers(manualLottoNumber))
                .collect(Collectors.toList());
    }

    private Lotto setManualLottoNumbers(String manualLottoNumber) {
        Lotto lotto = new Lotto();
        lotto.getLottos().clear();

        Arrays.stream(manualLottoNumber.split(","))
                .forEach(lottoNumber -> lotto.getLottos().add(Integer.parseInt(lottoNumber)));
        return lotto;
    }
}
