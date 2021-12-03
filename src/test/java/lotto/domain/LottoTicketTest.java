package lotto.domain;

import lotto.domain.util.LottoUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class LottoTicketTest {

    @Test
    @DisplayName("로또 자동 번호 발급 기능")
    void randomLottoNumbers() {
        assertThatCode(LottoTicket::randomLottoTicket)
                .doesNotThrowAnyException();
    }

    @Test
    void customLottoNumbers() {
        assertThatCode(() -> LottoTicket.customLottoTicket(1, 2, 3, 4, 5, 6))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @CsvSource(value = {"6,1/2/3/4/5/6", "0,7/8/9/10/11/12"})
    void sameCount(long count, String numbers) {
        List<LottoNumber> integers = LottoUtils.lottoNumbers(numbers);
        LottoTicket lottoTicket = LottoTicket.customLottoTicket(1, 2, 3, 4, 5, 6);
        LottoTicket targetLottoTicket = LottoTicket.customLottoTicket(integers);

        assertThat(lottoTicket.sameCount(targetLottoTicket))
                .isEqualTo(count);
    }
}
