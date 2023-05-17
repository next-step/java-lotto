package lotto.domain;

import lotto.domian.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecordTest {

    private List<Lotto> lottoList = new ArrayList<>();
    private LottoBundle lottoBundle;

    @BeforeEach
    public void setUp() {
        lottoList.add(Lotto.of(Arrays.asList(1,2,3,4,5,6)));
        lottoList.add(Lotto.of(Arrays.asList(1,2,3,4,6,7)));
        lottoBundle = new LottoBundle(lottoList);
    }

    @DisplayName("구매한 로또들 중에서 당첨된 것들을 뽑을 수 있다.")
    @Test
    public void pickRank_AmongLottoBundle_pickRanks() {
        String winNumberString = "1, 2, 3, 4, 5, 6";
        String bonusWinNumber = "7";
        WinNumber winNumber = LottoCompany.getInstance().announce(winNumberString, bonusWinNumber);

        Record record = Record.extractRecord(lottoBundle, winNumber);

        Assertions.assertThat(record.getRecord().get(Rank.FIRST)).isEqualTo(1);
        Assertions.assertThat(record.getRecord().get(Rank.SECOND)).isEqualTo(1);
    }
}
