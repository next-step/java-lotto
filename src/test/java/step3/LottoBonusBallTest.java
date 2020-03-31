package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoBonusBallTest {

    @Test
    @DisplayName("입력값 테스트")
    public void priceTest() {
        assertThatThrownBy(() -> new BuyInfo(0,2000)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값 테스트0보다 작은구매금액테스트")
    public void priceFailTest() {
        assertThatThrownBy(() -> new BuyInfo(-1,2000)).isInstanceOf(IllegalArgumentException.class);
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

    @Test
    @DisplayName("당첨정보결과테스트")
    public void matchTest() {
        WinLotto winLotto = new WinLotto("1,2,3,4,5,6",7);
        List<Integer> buyLottoList = Arrays.asList(1,2,3,4,5,7);
        assertThat(winLotto.match(buyLottoList)).isEqualTo(5);
    }

    @Test
    @DisplayName("5등당첨정보테스트")
    public void resultTest() {
        assertThat(WinInformation.matchWinInformation(3,false).getPrice()).isEqualTo(BigDecimal.valueOf(5000));
    }

    @Test
    @DisplayName("2등당첨정보테스트")
    public void resultBonusBallTest() {
        assertThat(WinInformation.matchWinInformation(5,true).getPrice()).isEqualTo(BigDecimal.valueOf(30000000));
    }

    @Test
    @DisplayName("전체건수 테스트")
    public void resultAllCountTest() {
        assertThat(WinInformation.matchWinInformationAllCount()).isEqualTo(5);
    }
}
