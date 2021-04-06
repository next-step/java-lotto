package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoShop {
    private final List<LottoGame> lottoGames;

    public LottoShop(Money money, LottoNumberService lottoNumberService) {
        this.lottoGames = lottoNumberService.creation(money);
    }

    public HitResults match(WinNumbers winNumbers) {
        HitResults hitResults = new HitResults();
        for (LottoGame lottoGame : lottoGames) {
            hitResults.add(lottoGame.match(winNumbers));
        }
        return hitResults;
    }

    public List<LottoGame> getLottoGames() {
        return lottoGames;
    }

    public int getGameCount() {
        return lottoGames.size();
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
