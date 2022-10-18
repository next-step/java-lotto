package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoUtils {

    public static List<Lotto> createTestLottos() {
        List<Lotto> lottoList = new ArrayList<>();

        lottoList.add(new Lotto("1, 2, 3, 4, 5, 6"));
        lottoList.add(new Lotto("1, 2, 3, 4, 5, 6"));
        lottoList.add(new Lotto("1, 2, 3, 4, 5, 10"));
        lottoList.add(new Lotto("1, 2, 3, 4, 5, 11"));
        lottoList.add(new Lotto("1, 2, 3, 4, 15, 20"));
        lottoList.add(new Lotto("1, 2, 3, 4, 15, 20"));
        lottoList.add(new Lotto("1, 2, 3, 14, 15, 20"));
        lottoList.add(new Lotto("1, 2, 3, 14, 15, 20"));
        lottoList.add(new Lotto("1, 2, 13, 14, 15, 20"));
        lottoList.add(new Lotto("1, 2, 13, 14, 15, 20"));

        return lottoList;
    }
}
