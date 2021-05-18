package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.util.LottoStringFixtureUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoTicketTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "1",
            "1,2",
            "1,2,3",
            "1,2,3,4",
            "1,2,3,4,5",
            "1,2,3,4,5,5",
            "1,2,3,4,5,6,7",
    })
    @DisplayName("로또티켓은 고유한 6개의 로또번호가 아니면 IllegalArgumentException이 발생한다")
    public void 로또티켓은_고유한_6개의_로또번호가_아니면_IllegalArgumentException이_발생한다(String fixtureLottoNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(LottoStringFixtureUtil.convertStringToLottoNumberList(fixtureLottoNumber)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1,2,3,5,8,9", "10,11,12,13,14,15"})
    @DisplayName("로또티켓은 6개의 로또번호를 가진다")
    public void 로또티켓은_6개의_로또번호를_가진다(String fixtureLottoNumber) {
        assertDoesNotThrow(() -> new LottoTicket(LottoStringFixtureUtil.convertStringToLottoNumberList(fixtureLottoNumber)));
    }
}
