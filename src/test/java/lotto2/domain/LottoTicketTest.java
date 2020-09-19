package lotto2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTicketTest {

    @DisplayName("로또티켓 생성 - 여섯개의 로또 번호를 입력")
    @Test
    void newInstance() {
        //given
        Set<LottoNumber> lottoNumbers = Stream.iterate(1, n -> n + 1)
                .limit(6)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        //when
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        //then
        assertThat(lottoTicket).isNotNull();
    }

    @DisplayName("로또티켓 생성 - 잘못된 개수의 로또 번호를 입력")
    @Test
    void newInstanceWithWrongLottoNumbers() {
        //given
        Set<LottoNumber> lottoNumbers = Stream.iterate(1, n -> n + 1)
                .limit(5)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(lottoNumbers))
                .withMessage("잘못된 개수의 로또번호를 입력하셨습니다.");
    }

    @DisplayName("당첨번호 일치 개수 확인")
    @Test
    void matchCount() {
        //given
        Set<LottoNumber> lottoNumbers = Stream.iterate(1, n -> n + 1)
                .limit(6)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        LottoTicket winningTicket = new LottoTicket(lottoNumbers);

        //when
        int matchCount = lottoTicket.matchCount(winningTicket);

        //then
        assertEquals(lottoNumbers.size(), matchCount);
    }
}