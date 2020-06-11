package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.LottoSeller;
import step2.LottoTicket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("로또 판매자 클래스 테스트")
public class LottoSellerTest {

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "10000:10", "7000:7"}, delimiter = ':')
    @DisplayName("금액 입력받고 금액만큼 로또 받는 테스트")
    void putMoneyGetLottoNumberList(int input, int expected) {
        LottoSeller seller = new LottoSeller();
        List<LottoTicket> lottoTicketList = seller.buyLotto(input);

        assertThat(lottoTicketList).hasSize(expected);
    }

    @Test
    @DisplayName("금액 1000단위로 제대로 입력했는지 테스트")
    void rightMoneyInputList() {
        LottoSeller seller = new LottoSeller();
        assertThatIllegalArgumentException().isThrownBy(() -> seller.buyLotto(100));
        assertThatIllegalArgumentException().isThrownBy(() -> seller.buyLotto(1100));
    }


    @Test
    @DisplayName("맞춤 갯수가 몇개인지 확인하는 테스트")
    void 숫자_몇개_맞췄나() {

        LottoTicket lottoTicket = LottoTicket.makeLottoTicket(Arrays.asList(1,2,3,4,5,6));
        LottoSeller seller = new LottoSeller();
        List<Integer> winningCountList = seller.requestLottoChecking("1,2,3,4,11,12", Collections.singletonList(lottoTicket));

        assertThat(4).isEqualTo(winningCountList.get(0));
    }

}
