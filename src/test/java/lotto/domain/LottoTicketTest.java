package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 단일 상품 테스트")
class LottoTicketTest {

    private final List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Test
    @DisplayName("로또번호 유효성 검사 Exception 발생")
    void lottoValidationExceptionTest() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 43, 44)
                .map(LottoNumber::new).collect(Collectors.toList());

        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("different number size");
    }

    @Test
    @DisplayName("로또 추첨 번호와 매칭 확인 - 6개")
    void lottoSixMatchTest() {
        // given
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new).collect(Collectors.toList());
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        // when
        int actual = lottoTicket.matchingTicket(winningNumbers);

        //then
        assertThat(actual).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 추첨 번호와 매칭 확인 - 5개")
    void lottoFiveMatchTest() {
        // given
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 45)
                .map(LottoNumber::new).collect(Collectors.toList());
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        // when
        int actual = lottoTicket.matchingTicket(winningNumbers);

        //then
        assertThat(actual).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 추첨 번호와 매칭 확인 - 4개")
    void lottoFourMatchTest() {
        // given
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 44, 45)
                .map(LottoNumber::new).collect(Collectors.toList());
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        // when
        int actual = lottoTicket.matchingTicket(winningNumbers);

        //then
        assertThat(actual).isEqualTo(4);
    }

    @Test
    @DisplayName("로또 추첨 번호와 매칭 확인 - 3개")
    void lottoThreeMatchTest() {
        // given
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 43, 44, 45)
                .map(LottoNumber::new).collect(Collectors.toList());
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        // when
        int actual = lottoTicket.matchingTicket(winningNumbers);

        //then
        assertThat(actual).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 추첨 번호와 매칭 확인 - 2개")
    void lottoTwoMatchTest() {
        // given
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 42, 43, 44, 45)
                .map(LottoNumber::new).collect(Collectors.toList());
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        // when
        int actual = lottoTicket.matchingTicket(winningNumbers);

        //then
        assertThat(actual).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 추첨 번호와 매칭 확인 - 1개")
    void lottoOneMatchTest() {
        // given
        List<LottoNumber> lottoNumbers = Stream.of(1, 41, 42, 43, 44, 45)
                .map(LottoNumber::new).collect(Collectors.toList());
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        // when
        int actual = lottoTicket.matchingTicket(winningNumbers);

        //then
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 추첨 번호와 매칭 확인 - 0개")
    void lottoZeroMatchTest() {
        // given
        List<LottoNumber> lottoNumbers = Stream.of(40, 41, 42, 43, 44, 45)
                .map(LottoNumber::new).collect(Collectors.toList());
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        // when
        int actual = lottoTicket.matchingTicket(winningNumbers);

        //then
        assertThat(actual).isEqualTo(0);
    }
}