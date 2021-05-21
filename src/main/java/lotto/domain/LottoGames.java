package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoGames {

    private List<LottoGame> values;

    public LottoGames() {
        values = new ArrayList<>();
    }

    public LottoGames(List<LottoGame> values) {
        this.values = values;
    }

    public void add(LottoGame lottoGame) {
        this.values.add(lottoGame);
    }

    public LottoGame get(int index) {
        return values.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGames that = (LottoGames) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
