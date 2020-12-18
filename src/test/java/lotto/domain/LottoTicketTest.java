package lotto.domain;

import lotto.exception.LottoNumberCountNotEnoughException;
import lotto.util.StringSplitter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTicketTest {

    private LottoMachine lottoMachine = LottoMachine.instance();

    @Test
    @DisplayName("로또 티켓 테스트")
    void lotto_ticket_count() {
        assertThatCode(() -> lottoMachine.generateAutoLottoNumber())
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 번호 중복 테스트")
    void duplicate_lotto_number_test() {
        assertThatExceptionOfType(LottoNumberCountNotEnoughException.class).isThrownBy(() -> {
            // given
            Set<LottoNumber> lottoNumbers = Stream.of(LottoNumber.ofNumber(1), LottoNumber.ofNumber(1),
                    LottoNumber.ofNumber(3), LottoNumber.ofNumber(43), LottoNumber.ofNumber(44), LottoNumber.ofNumber(45))
                    .collect(Collectors.toCollection(HashSet::new));

            // when & then
            LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        }).withMessageMatching("로또 번호 또는 당첨 번호는 6개를 입력해주세요.");
    }

    @Test
    @DisplayName("두 로또 번호를 비교해 맞은 개수 반환 테스트")
    void count_match_numbers() {
        // given
        LottoNumbers winningNumbers = new LottoNumbers(StringSplitter.splitText("1,2,3,4,5,6"));
        LottoTicket winningLotto = lottoMachine.generateManualLottoNumbers(winningNumbers);

        LottoNumbers compareNumbers = new LottoNumbers(StringSplitter.splitText("1,2,3,4,44,45"));
        LottoTicket compareLotto = lottoMachine.generateManualLottoNumbers(compareNumbers);

        // when & then
        assertEquals(4, winningLotto.countMatchNumbers(compareLotto));
    }

}
