package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class LottoTest {

    @Test
    @DisplayName("정수입력 테스트")
    public void test1(){
        Lotto lotto = new Lotto();
        assertThat(lotto.integerValidation("140000")).isTrue();
        assertThat(lotto.integerValidation("14,0000")).isFalse();
    }

    @Test
    @DisplayName("로또 구매 수량")
    public void test2(){
        Lotto lotto = new Lotto();
        assertThat(lotto.lottoQuantity("14000")).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 번호 뽑기")
    public void test3(){
        Lotto lotto = new Lotto();
        assertThat(lotto.outputLottoNumber().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("총 구매 로또 수")
    public void test4(){
        Lotto lotto = new Lotto();
        assertThat(lotto.getPurchasedLottery(2).size()).isEqualTo(2);

    }

}
