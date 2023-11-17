package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMain {

    public static void main(String[] args) {

    }

    public static List<Lotto> puchase(int money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / 1000; ++i) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
