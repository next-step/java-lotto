package step4.controller;

import step4.domain.Amount;
import step4.domain.Lotto;
import step4.domain.LottoNumber;
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

    private LottoTicketMaker(int manualLottoQty, Amount amount, List<LottoNumber> lottoNumber) {
        this.amount = amount;
        this.manualLottoQty = manualLottoQty;
        this.autoQty = lottoAutoPurchaseQty();
        this.lottoTicket = create(lottoNumber);

    }

    public static LottoTicketMaker of(Amount amount, int manualLottoQty, List<LottoNumber> lottos) {
        return new LottoTicketMaker(manualLottoQty, amount, lottos);
    }

    public int lottoAutoPurchaseQty() {
        return amount.lottoPurchaseQty() - this.manualLottoQty;
    }

    private Lottos create(List<LottoNumber> lottos) {
        List<Lotto> lotto = new ArrayList<>();
        lotto.add(Lotto.of(lottos));

        IntStream.range(0, lottoAutoPurchaseQty())
                .mapToObj(i -> lottoTicketCreate())
                .forEach(lotto::add);

        return new Lottos(lotto);
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

    public static List<LottoNumber> askManualLottoNumbers(int numberOfManualLottos, String manualLottoNumber) {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 0; i < numberOfManualLottos; i++) {
            numbers = setManualLottoNumbers(manualLottoNumber);
        }
        return numbers;
    }

    private static List<LottoNumber> setManualLottoNumbers(String manualLottoNumber) {
        return Arrays.stream(manualLottoNumber.split(","))
                .map(lottoNumber -> new LottoNumber(Integer.parseInt(lottoNumber)))
                .collect(Collectors.toList());
    }
}
