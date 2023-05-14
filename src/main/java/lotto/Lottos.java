package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private List<Lotto> lottoList;

    public Lottos(int count) {
        lottoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto());
        }
    }

    public void shuffleLottos(LottoBalls lottoBalls) {
        for (Lotto lotto : lottoList) {
            lotto.shuffleLottoNumber(lottoBalls);
        }
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }
}
