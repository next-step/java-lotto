package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<LottoNumber> lotto = new ArrayList<>();

    public Lotto() {}

    public void playLotto(int count) {
        for (int i = 0; i < count; i++) {
            lotto.add(new LottoNumber());
        }
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lotto=" + lotto +
                '}';
    }
}
