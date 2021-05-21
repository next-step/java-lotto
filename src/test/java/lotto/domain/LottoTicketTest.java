package lotto.domain;

import lotto.utils.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    @DisplayName("생성된 로또티켓의 로또번호 갯수는 6개여야한다.")
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
