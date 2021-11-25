package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static lotto.utils.Constants.NUMBER_ZERO;

public class Lottoes {
    private List<LottoGame> lottoGames;

    public Lottoes() {
        this.lottoGames = new ArrayList<>();
    }

    public Lottoes(List<LottoGame> lottoGames) {
        this.lottoGames = lottoGames;
    }

    public void makeLottoes(LottoGameCount lottoGameCount) {
        for (int i = NUMBER_ZERO; i < lottoGameCount.getLottoGameCount(); i++) {
            lottoGames.add(new LottoGame(new LottoNumbers().createAutoLottoNumbers()));
        }
    }

    public List<LottoGame> getLottoGames() {
        return lottoGames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottoes lottoes = (Lottoes) o;
        return Objects.equals(lottoGames, lottoes.lottoGames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoGames);
    }
}
