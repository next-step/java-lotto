package lotto;

import lotto.domain.LottoGame;
import lotto.model.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest
{
    @Test
    @DisplayName("지불한 금액으로 로또를 할수 있는 횟수")
    void 로또_개수(){
        long result = LottoHit.getPurchaseCount(2000);
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("여러개_자동_로또번호 채번")
    void 여러개_자동_로또번호() {
        List<LottoNumber> lottos = LottoHit.getLotto(7);
        assertThat(lottos.size()).isEqualTo(7);
    }




}
