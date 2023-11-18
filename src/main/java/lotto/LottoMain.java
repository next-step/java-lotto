package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;

public class LottoMain {

    private static final int lottoPrice = 1000;

    public static void main(String[] args) {
    }

    public static List<Lotto> puchase(int money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / lottoPrice; ++i) {
            lottos.add(new Lotto(new LottoNumbers()));
        }
        return lottos;
    }
}
