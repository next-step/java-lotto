package lottoGame.fixture;

import java.util.ArrayList;
import java.util.List;
import lottoGame.model.lotto.LottoNum;
import lottoGame.model.winner.BeforeWinNums;

public class LottoFixture {

    public static List<LottoNum> 로또번호리스트를_오름차순으로_생성한다(int size) {
        return createLottoNumsInRange(0, size);
    }

    public static List<LottoNum> 로또번호리스트를_지정해서_생성한다(int start, int end) {
        return createLottoNumsInRange(start, end);
    }

    private static List<LottoNum> createLottoNumsInRange(int start, int end) {
        List<LottoNum> lottoNums = new ArrayList<>();
        for (int i = start; i < end; i++) {
            lottoNums.add(new LottoNum(i + 1));
        }

        return lottoNums;
    }


    public static BeforeWinNums 당첨번호리스트를_오름차순으로_생성한다(int size) {
        return createIntsInRange(0, size);
    }

    public static BeforeWinNums 당첨번호리스트를_지정해서_생성한다(int start, int end) {
        return createIntsInRange(start, end);
    }

    private static BeforeWinNums createIntsInRange(int start, int end) {
        List<Integer> winNums = new ArrayList<>();
        for (int i = start; i < end; i++) {
            winNums.add(i + 1);
        }

        return new BeforeWinNums(winNums);
    }


}
