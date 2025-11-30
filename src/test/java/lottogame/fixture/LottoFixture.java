package lottogame.fixture;

import java.util.HashSet;
import java.util.Set;
import lottogame.model.lotto.LottoNum;

public class LottoFixture {

    public static Set<LottoNum> 로또번호리스트를_오름차순으로_생성한다(int size) {
        return createLottoNumsInRange(1, size);
    }

    public static Set<LottoNum> 로또번호리스트를_지정해서_생성한다(int start, int end) {
        return createLottoNumsInRange(start, end);
    }

    private static Set<LottoNum> createLottoNumsInRange(int start, int end) {
        Set<LottoNum> lottoNums = new HashSet<>();
        for (int i = start; i <= end; i++) {
            lottoNums.add(new LottoNum(i));
        }

        return lottoNums;
    }
}
