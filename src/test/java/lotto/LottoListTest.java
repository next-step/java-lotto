package lotto;

import lotto.domain.Lotto;
import lotto.domain.entity.LottoList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoListTest {

    @Test
    @DisplayName("구매 금액이나 로또 여러장으로 LottoList 를 생성한다.")
    public void 로또_생성자_확인(){
        LottoList amountLotto = new LottoList(5);
        assertThat(amountLotto.size()).isEqualTo(5);

        LottoList arrayLotto = new LottoList(new Lotto(Arrays.asList(1,2,3,4,5,6)), new Lotto(Arrays.asList(1,2,3,4,5,7)));
        assertThat(arrayLotto.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 한장을 정상적으로 반환하는지 확인한다.")
    public void 로또_가져오기(){
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        LottoList lottoList = new LottoList(lotto);
        assertThat(lottoList.get(0)).isEqualTo(lotto);
    }
}
