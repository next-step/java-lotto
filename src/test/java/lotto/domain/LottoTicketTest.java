package lotto.domain;

import lotto.utils.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    @DisplayName("로또 티켓 생성하기")
    @Test
    public void createLottoTicket() {
        List<String> lottoNumberText = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<LottoNumber> lottoNumbers = makeLottoNumbers(lottoNumberText);

        LottoTicket lottoTicket = LottoTicket.create(lottoNumbers);

        assertThat(lottoTicket.getNumbers()).hasSize(6);
    }

    @DisplayName("로도 번호가 6개가 아닐때 예외")
    @Test
    public void invalidLottoNumberCountTest() {
        List<String> lottoNumberText = Arrays.asList("1", "2", "3", "4", "5");
        List<LottoNumber> lottoNumbers = makeLottoNumbers(lottoNumberText);

        assertThatThrownBy(() -> LottoTicket.create(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private List<LottoNumber> makeLottoNumbers(List<String> lottoNumberText) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        return lottoNumberGenerator.generator(lottoNumberText);
    }

}
