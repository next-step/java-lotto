package lotto.domain.lotto;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;
import lotto.domain.winning.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("LottoTicket 클래스 테스트")
public class LottoTicketTest {

    @DisplayName("입력받은 갯수 만큼 LottoTicket을 생성할 수 있다.")
    @Test
    void createLottoTicket() {
        Price price= new Price(3000);
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(price, Collections.emptyList());
        LottoTicket lottoTicket = new LottoTicket(lottoNumberGenerator.getLottoNumbers());

        assertAll(
                () -> assertThat(lottoTicket.getLottoNumbers()).hasSize(price.getLottoCount()),
                () -> assertThat(lottoTicket.getLottoNumbers().get(0).getClass()).isEqualTo(LottoNumbers.class)
        );
    }

    @DisplayName("WinningNumbers와 매칭 결과(LottoRank)를 반환한다.")
    @Test
    void matchWinningNumber() {
        Price price= new Price(1000);
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(price, Collections.singletonList("1,2,3,4,5,6"));

        System.out.println(lottoNumberGenerator);

        String winningNumberString = "1,2,3,4,5,6";
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(winningNumberString);
        LottoNumber bonusLottoNumber = new LottoNumber(bonusNumber);

        LottoTicket lottoTicket = new LottoTicket(lottoNumberGenerator.getLottoNumbers());

        Map<LottoRank, Long> lottoRankLongMap = lottoTicket.matchWinningNumber(winningLotto, bonusLottoNumber);

        assertThat(lottoRankLongMap.get(LottoRank.FIRST)).isEqualTo(new Long(price.getLottoCount()));
    }

    @DisplayName("수동 로또 번호를 생성할 수 있다.")
    @Test
    void create_manualLotto() {
        Price price= new Price(1000);
        List<String> manualLottos = Collections.singletonList("1,2,3,4,5,6");

        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(price, manualLottos);
        LottoTicket lottoTicket = new LottoTicket(lottoNumberGenerator.getLottoNumbers());

        assertThat(lottoTicket.getLottoNumbers()).hasSize(1);
    }
}
