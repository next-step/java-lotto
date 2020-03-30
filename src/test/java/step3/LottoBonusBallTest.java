package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.BuyInfo;
import step3.domain.Lotto;
import step3.domain.LottoInfo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoBonusBallTest {

    @Test
    @DisplayName("입력값 테스트")
    public void priceTest() {
        assertThatThrownBy(() -> new BuyInfo(0,2000)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입가능한게임수 구하기")
    public void totalCountTest() {
        assertThat(new BuyInfo(10000,2000).getTotalCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("로또한장당가격 구하기")
    public void oneGamePriceTest(){
        LottoInfo lottoInfo = new LottoInfo(1000);
        assertThat(lottoInfo.getLottoPrice()).isEqualTo(1000);
    }

    @Test
    @DisplayName("랜덤추출 구현테스트")
    public void getLottoRandomTest(){
        Lotto lotto = new Lotto();
        assertThat(lotto.getRandomLottoList().size()).isEqualTo(6);
    }
}
