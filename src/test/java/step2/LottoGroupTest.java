package step2;

import org.junit.jupiter.api.Test;
import step2.model.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static step2.model.LottoGroup.*;

public class LottoGroupTest {
    @Test
    public void 자동_로또_발급() {
        //given
        LottoGroup lottoGroup = getAutoLotto(new AutoLottoStrategy(), 3);

        //then
        assertThat(lottoGroup.size()).isEqualTo(3);
    }

    @Test
    public void 수동_로또_발급() {
        //given
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto("1,2,3,4,5,6"));
        lottoList.add(new Lotto("2,23,31,44,15,6"));
        LottoGroup lottoGroup = getManualLotto(lottoList);

        //then
        assertThat(lottoGroup.size()).isEqualTo(2);
    }
}
