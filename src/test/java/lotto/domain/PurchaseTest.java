package lotto.domain;

import lotto.domain.enums.PickType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseTest {

    @Test
    void testGetPicks(){
        Purchase purchase = new Purchase();
        Pick pick = new Pick();
        pick.setType(PickType.AUTO);
        pick.setBalls(Arrays.asList(1,2,3,4,5,6));
        purchase.setPicks(Arrays.asList(pick));
        Set<Pick> pickSet = purchase.getPicks();
        assertThat(pickSet).isNotEmpty();
    }

    @Test
    void testGetReports(){
        Purchase purchase = new Purchase();
        LottoReport lottoReport = new LottoReport();
        purchase.setReport(lottoReport);

        assertThat(purchase.getReport()).isNotNull();
    }
}
