package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import camp.nextstep.edu.rebellion.lotto.rule.LottoGameRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicketGenerator {
    private LottoTicketGenerator() {}

    public static LottoTicket purchaseGoodLuck(PurchaseAmount purchaseAmount, List<String> manualLottoNumbers) {
        List<Lotto> lottos = new ArrayList<>();

        lottos.addAll(makeAutoLottos(purchaseAmount.getAutoCountOfPurchase()));
        lottos.addAll(makeManualLottos(manualLottoNumbers));

        return new LottoTicket(lottos);
    }

    private static List<Lotto> makeAutoLottos(int lottoCount) {
        return Stream.generate(LottoTicketGenerator::generateNumbers)
                .limit(lottoCount)
                .collect(Collectors.toList());
    }

    private static Lotto generateNumbers() {
        return LottoNumberDice.roll()
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Lotto::new));
    }

    private static List<Lotto> makeManualLottos(List<String> manualLottoNumbers) {
        return manualLottoNumbers
                .stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }
}
