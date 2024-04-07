package lotto.domain;

import lotto.service.LottoService;

import java.util.List;

public class LottoShop {

    LottoFee lottoFee;
    Lottos lottos;

    public LottoShop(LottoFee lottoFee) {
        this.lottoFee = lottoFee;
        this.lottos = new Lottos();
    }

    public Lottos buy(List<List<Integer>> manualLottos) {
        validateManualGameCount(manualLottos.size());
        lottos.addAll(LottoGenerator.auto(lottoFee.totalCount() - manualLottos.size()));
        lottos.addAll(LottoGenerator.manual(manualLottos));
        return lottos;
    }

    private void validateManualGameCount(int manualLottoCount) {
        LottoService.validateManualGameCount(manualLottoCount, lottoFee.totalCount());
    }

    public int totalCount() {
        return lottoFee.totalCount();
    }

    public int fee() {
        return lottoFee.getValue();
    }
}
