package lotto;

import java.util.ArrayList;
import java.util.List;

public class PlayLotto {
    private static int LOTTO_PRICE = 1000;
    private List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> createLotto(int cash) {
        int lottoCount = cash / LOTTO_PRICE;
        for(int i=0; i<lottoCount; i++){
            lottos.add(new Lotto(new CreateShffledLottoNumbers()));
        }
        return lottos;
    }
}
