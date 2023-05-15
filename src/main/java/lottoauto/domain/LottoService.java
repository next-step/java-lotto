package lottoauto.domain;

import java.util.ArrayList;
import java.util.List;
import lottoauto.model.Lotto;
import lottoauto.model.Lottos;
import lottoauto.model.request.LottoRequest;

public class LottoService {

    public Lottos generateLottoNumber(LottoRequest request) {
        List<Lotto> lottoManuals = request.getManualLotteryNumbers();
        List<Lotto> lottoAutos = generateLottoAuto(request.availableAutoLotteryCount());
        lottoManuals.addAll(lottoAutos);
        return new Lottos(lottoManuals);
    }

    private List<Lotto> generateLottoAuto(int quantity) {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lotto.add(Lotto.auto());
        }
        return lotto;
    }

}
