package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoShop {
    private final List<LottoGame> lottoGames;

    public LottoShop() {
        this.lottoGames = new ArrayList<>();
    }

    public void purchase(Money payMoney) {
        purchase(payMoney, new ArrayList<>(0));
    }

    public void purchase(Money payMoney, List<Numbers> manualNumbers) {
        validatePurchase(payMoney, manualNumbers);
        manualLotto(manualNumbers);
        autoLotto(payMoney.lottoGameCount() - manualNumbers.size());
    }

    private void validatePurchase(Money payMoney, List<Numbers> manualNumbers) {
        if (manualNumbers.size() > payMoney.lottoGameCount()) {
            throw new IllegalArgumentException(String.format("구매할 수 있는 최대 수는 %d 입니다.", payMoney.lottoGameCount()));
        }
    }

    private void autoLotto(int count) {
        for (int i = 0; i < count; i++) {
            lottoGames.add(new LottoGame(new AutoNumberService()));
        }
    }

    private void manualLotto(List<Numbers> manualNumbers) {
        for (Numbers manualNumber : manualNumbers) {
            lottoGames.add(new LottoGame(new ManualNumberService(manualNumber)));
        }
    }

    public HitResults match(WinNumbers winNumbers) {
        HitResults hitResults = new HitResults();
        for (LottoGame lottoGame : lottoGames) {
            hitResults.add(lottoGame.lotto(winNumbers));
        }
        return hitResults;
    }

    public List<LottoGame> getLottoGames() {
        return lottoGames;
    }

    public int getGameCount() {
        return lottoGames.size();
    }

    public int getAutoGameCount() {
        return (int) lottoGames.stream()
                .filter(lottoGame ->
                        lottoGame.getLottoNumberService().getClass() == AutoNumberService.class)
                .count();
    }

    public int getManualGameCount() {
        return getGameCount() - getAutoGameCount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoShop lottoShop = (LottoShop) o;
        return Objects.equals(lottoGames, lottoShop.lottoGames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoGames);
    }
}
