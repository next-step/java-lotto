package step4.VO;

import step4.LottoGenerator;

import java.util.List;

public class LottoStore {
    public static void buyManualLottos(Lottos lottos, List<Lotto> manualLottoNumbersList) {
        for (Lotto manualLottoNumbers: manualLottoNumbersList) {
            lottos.inputLotto(new Lotto(manualLottoNumbers.getNumberList()));
        }
    }

    public static void buyAutoLottos(Lottos lottos, Money money, LottoGenerator lottoGenerator) {
        int autoCnt = lottos.getAutoLottoCnt(money);
        for (int i = 1; i <= autoCnt; i++) {
            lottos.inputLotto(new Lotto(lottoGenerator.getLottoNumbers()));
        }
    }

}
