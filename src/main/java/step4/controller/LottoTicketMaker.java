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

    private final Lottos lottoTicket;

    private final int manualLottoQty;

    private Lotto lotto;

    private LottoTicketMaker(int manualLottoQty, Amount amount, List<Lotto> manualLottoNumbers) {
        this.amount = amount;
        this.manualLottoQty = manualLottoQty;
        this.lottoTicket = create(manualLottoNumbers);
    }

    public static LottoTicketMaker of(Amount amount, int manualLottoQty, List<Lotto> manualLottoNumbers) {
        return new LottoTicketMaker(manualLottoQty, amount, manualLottoNumbers);
    }

    public int lottoAutoPurchaseQty() {
        return amount.lottoPurchaseQty() - this.manualLottoQty;
    }

    private Lottos create(List<Lotto> lottoNumbers) {
        IntStream.range(0, lottoAutoPurchaseQty()).forEach(i -> {
            lottoTicketCreate();
            lottoNumbers.add(this.lotto);
        });

        return new Lottos(lottoNumbers);
    }

    private void lottoTicketCreate() {
        IntStream.range(0, LOTTO_TOTAL_COUNT)
                .forEach(j -> lotto = new Lotto());
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
