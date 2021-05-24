package lottoAuto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoResultsTest {

    private List<LottoResultTest> lottoResultTestList;

    public LottoResultsTest() {
        lottoResultTestList = new ArrayList<>();
    }

    public void add(LottoResultTest lottoResultTest) {
        lottoResultTestList.add(lottoResultTest);
    }

    public int getLottoResultTestList1() {
        return lottoResultTestList.get(0).getCount();
    }

    public int getLottoResultTestList2() {
        return lottoResultTestList.get(1).getCount();
    }
}
