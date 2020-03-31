package lotto;

import lotto.domain.*;
import lotto.dto.LottoRequestDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoShop {
    private LottoBundle lottoBundle;

    public LottoShop() {
    }

    public LottoShop(LottoBundle lottoBundle) {
        this.lottoBundle = lottoBundle;
    }

    public void buyLotto(LottoRequestDto lottoRequestDto) {
        Purchase purchase = new Purchase(lottoRequestDto.getAmount(), lottoRequestDto.getManualCount());
        List<String> manualLottoStrings = lottoRequestDto.getManualLottoStrings();

        LottoBundle autoLottoBundle = buyAuto(purchase.countOfAuto());
        lottoBundle = autoLottoBundle.join(buyManual(manualLottoStrings));
    }

    public LottoBundle buyAuto(int lottoCount) {
        return new LottoBundle(toLottos(lottoCount));
    }

    public LottoBundle buyManual(List<String> lottoStrings) {
        List<Lotto> manualLottos = lottoStrings.stream()
                .map(Lotto::manual)
                .collect(Collectors.toList());
        return new LottoBundle(manualLottos);
    }

    private List<Lotto> toLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.auto());
        }
        return lottos;
    }

    public LottoResult checkWinning(LottoRequestDto lottoRequestDto) {
        List<WinningType> winningTypes = lottoBundle.drawForWinning(lottoRequestDto.getWinningNumber(), lottoRequestDto.getBonusNumber());
        return new LottoResult(winningTypes, lottoBundle.size());
    }

    public LottoBundle getLottoBundle() {
        return lottoBundle;
    }
}
