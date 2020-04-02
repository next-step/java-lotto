package step3;

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
        assertThatThrownBy(() -> new BuyInfo(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값 테스트0보다 작은구매금액테스트")
    public void priceFailTest() {
        assertThatThrownBy(() -> new BuyInfo(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입가능한게임수 구하기")
    public void totalCountTest() {
        assertThat(new BuyInfo(10000).getTotalCount()).isEqualTo(10);
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
        WinLotto winLotto = new WinLotto("1,2,3,4,5,6",LottoNumber.of(7));
        LottoNumberList buyLottoList = new LottoNumberList(Arrays.asList(LottoNumber.of(1),LottoNumber.of(2),LottoNumber.of(3),LottoNumber.of(4),LottoNumber.of(5),LottoNumber.of(8)));
        assertThat(winLotto.match(buyLottoList)).isEqualTo(5);
    }

    @Test
    @DisplayName("5등당첨정보테스트")
    public void resultTest() {
        assertThat(RankInformation.matchWinInformation(3,false).getPrice()).isEqualTo(BigDecimal.valueOf(5000));
    }

    @Test
    @DisplayName("2등당첨정보테스트")
    public void resultBonusBallTest() {
        assertThat(RankInformation.matchWinInformation(5,true).getPrice()).isEqualTo(BigDecimal.valueOf(30000000));
    }

    @Test
    @DisplayName("전체건수 테스트")
    public void resultAllCountTest() {
        assertThat(RankInformation.matchWinInformationAllCount()).isEqualTo(5);
    }
}
