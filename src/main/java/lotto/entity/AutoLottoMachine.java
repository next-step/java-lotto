package lotto.entity;


import java.util.ArrayList;
import java.util.List;

public class AutoLottoMachine {

    private AutoLottoMachine() {

    }

    public static List<Lotto> createLotto(int count) {

        List<Lotto> lottos = new ArrayList<>();
        final LottoRandomizer lottoRandomizer = new LottoRandomizer();

        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.valueOf(lottoRandomizer.lottoShuffle()));
        }
        return lottos;
    }

}
