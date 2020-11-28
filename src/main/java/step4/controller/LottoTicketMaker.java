package step4.controller;

import step4.domain.Amount;
import step4.domain.Lotto;
import step4.domain.Lottos;
import step4.domain.Numbers;
import step4.util.NumbersValidate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketMaker {

    private static final int LOTTO_TOTAL_COUNT = 6;

    private final Amount amount;

    private Lottos lottoTicket;

    private final int manualLottoQty;


    private LottoTicketMaker(int manualLottoQty, Amount amount, List<Lotto> lottoNumber) {
        this.amount = amount;
        this.manualLottoQty = manualLottoQty;
        this.lottoTicket = create(lottoNumber);
    }

    public static LottoTicketMaker of(Amount amount, int manualLottoQty, List<Lotto> lottos) {
        return new LottoTicketMaker(manualLottoQty, amount, lottos);
    }

    public int lottoAutoPurchaseQty() {
        return amount.lottoPurchaseQty() - this.manualLottoQty;
    }

    private Lottos create(List<Lotto> lottos) {
        IntStream.range(0, lottoAutoPurchaseQty())
                .mapToObj(i -> lottoTicketCreate())
                .forEach(lottos::add);

        return new Lottos(lottos);
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

    public static List<Lotto> askManualLottoNumbers(List<Numbers> numbers) {
        List<Lotto> lotto = new ArrayList<>();
        numbers.forEach(lottoNumbers -> {
            NumbersValidate.validate(lottoNumbers.getLottoNumber());
            lotto.add(Lotto.of(setManualNumbers(lottoNumbers)));
        });
        return lotto;
    }

    private static List<Numbers> setManualNumbers(Numbers numbers) {
        return Arrays.stream(numbers.getLottoNumber()
                .split(",")).map(Numbers::of)
                .collect(Collectors.toList());
    }
}
