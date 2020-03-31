package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoResult;
import lotto.domain.WinningType;
import lotto.dto.LottoRequestDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoShop {
    private static final int PRICE_PER_PIECE = 1000;
    private LottoBundle lottoBundle;

    public LottoShop() {
    }

    public LottoShop(LottoBundle lottoBundle) {
        this.lottoBundle = lottoBundle;
    }

    public void buyLotto(LottoRequestDto lottoRequestDto) {
        int price = lottoRequestDto.getPrice();
        int manualCount = lottoRequestDto.getManualCount();
        List<String> manualLottoStrings = lottoRequestDto.getManualLottoStrings();

        validatePrice(price, manualCount);
        int lottoCount = Math.floorDiv(price, PRICE_PER_PIECE);

        List<Lotto> lottos = buyAuto(lottoCount - manualCount);
        List<Lotto> manualLottos = buyManual(manualLottoStrings);
        lottos.addAll(manualLottos);
        this.lottoBundle = new LottoBundle(lottos);
    }

    public List<Lotto> buyAuto(int lottoCount) {
        return toLottos(lottoCount);
    }

    public List<Lotto> buyManual(List<String> lottoStrings) {
        return lottoStrings.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private List<Lotto> toLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    private void validatePrice(int price, int manualCount) {
        if (price < PRICE_PER_PIECE) {
            throw new IllegalArgumentException("로또 가격은 1000원 이상이어야 합니다.");
        }

        if (price < manualLottoPrice(manualCount)) {
            throw new IllegalArgumentException("수동 구입 로또가 구입금액 보다 많습니다.");
        }
    }

    private int manualLottoPrice(int manualCount) {
        return PRICE_PER_PIECE * manualCount;
    }

    public LottoResult checkWinning(LottoRequestDto lottoRequestDto) {
        List<WinningType> winningTypes = lottoBundle.drawForWinning(lottoRequestDto.getWinningNumber(), lottoRequestDto.getBonusNumber());
        return new LottoResult(winningTypes, lottoBundle.size());
    }

    public LottoBundle getLottoBundle() {
        return lottoBundle;
    }
}
