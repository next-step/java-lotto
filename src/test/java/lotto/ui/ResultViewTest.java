package lotto.ui;

import lotto.domain.LottoGroup;
import org.junit.jupiter.api.Test;

public class ResultViewTest {
    private static final int COUNT_OF_LOTTO = 14;
    @Test
    public void printLottoGroup() {
        LottoGroup lottoGroup = new LottoGroup(COUNT_OF_LOTTO);
        ResultView.printLottoGroup(lottoGroup);
    }
}
