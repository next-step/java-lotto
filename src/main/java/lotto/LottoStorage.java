package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStorage {

    private final List<Lotto> lottoList;

    private LottoStorage(int count) {
        this.lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = Lotto.generate();
            lottoList.add(lotto);
        }
    }

    public static LottoStorage create(int count) {
        return new LottoStorage(count);
    }

    public List<Lotto> copy() {
        List<Lotto> result = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            result.add(Lotto.from(lotto));
        }
        return result;
    }
}
