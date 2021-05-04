package lotto.automatic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAutomaticResultViewTest {

    LottoAutomaticResultView resultView = new LottoAutomaticResultView();

    @DisplayName("가격을 넣었을경우 갯수 가 같게 나오는지")
    @Test
    void input(){
        int buycount=resultView.resultBuyPrice(14000);
        assertThat(buycount).isSameAs(14);
    }

    @DisplayName("리스트 출력")
    @Test
    void resulLottoList(){
        ArrayList<List> list = new ArrayList<>();

        list.add(Arrays.asList(1,3,12,23,34,44));
        list.add(Arrays.asList(3,4,22,35,36,45));
        list.add(Arrays.asList(2,7,17,22,30,43));

        resultView.resultLottoList(list);
    }


}
