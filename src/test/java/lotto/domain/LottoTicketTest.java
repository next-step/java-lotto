package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTicketTest {

    @Test
    @DisplayName("등수 조회")
    void rank() {
        // given
        Set<LottoNumber> lottoNumberList = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::of).collect(Collectors.toSet());
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        // when
        Set<LottoNumber> lottoNumberMatch6 = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::of).collect(Collectors.toSet());
        LottoNumbers lottoNumbersMatch6 = new LottoNumbers(lottoNumberMatch6);

        Set<LottoNumber> lottoNumberMatch5 = Stream.of(7, 2, 3, 4, 5, 6).map(LottoNumber::of).collect(Collectors.toSet());
        LottoNumbers lottoNumbersMatch5 = new LottoNumbers(lottoNumberMatch5);

        Set<LottoNumber> lottoNumberMatch4 = Stream.of(7, 8, 3, 4, 5, 6).map(LottoNumber::of).collect(Collectors.toSet());
        LottoNumbers lottoNumbersMatch4 = new LottoNumbers(lottoNumberMatch4);

        Set<LottoNumber> lottoNumberMatch3 = Stream.of(7, 8, 9, 4, 5, 6).map(LottoNumber::of).collect(Collectors.toSet());
        LottoNumbers lottoNumbersMatch3 = new LottoNumbers(lottoNumberMatch3);

        Set<LottoNumber> lottoNumberMatch2 = Stream.of(7, 8, 9, 10, 5, 6).map(LottoNumber::of).collect(Collectors.toSet());
        LottoNumbers lottoNumbersMatch2 = new LottoNumbers(lottoNumberMatch2);

        Set<LottoNumber> lottoNumberMatch1 = Stream.of(7, 8, 9, 10, 11, 12).map(LottoNumber::of).collect(Collectors.toSet());
        LottoNumbers lottoNumbersMatch1 = new LottoNumbers(lottoNumberMatch1);

        Set<LottoNumber> lottoNumberMatch0 = Stream.of(7, 8, 9, 10, 11, 12).map(LottoNumber::of).collect(Collectors.toSet());
        LottoNumbers lottoNumbersMatch0 = new LottoNumbers(lottoNumberMatch0);

        // then
        assertThat(lottoTicket.rank(lottoNumbersMatch6, LottoNumber.of(45))).isEqualTo(LottoRank.FIRST);
        assertThat(lottoTicket.rank(lottoNumbersMatch5, LottoNumber.of(1))).isEqualTo(LottoRank.SECOND);
        assertThat(lottoTicket.rank(lottoNumbersMatch5, LottoNumber.of(45))).isEqualTo(LottoRank.THIRD);
        assertThat(lottoTicket.rank(lottoNumbersMatch4, LottoNumber.of(45))).isEqualTo(LottoRank.FOURTH);
        assertThat(lottoTicket.rank(lottoNumbersMatch3, LottoNumber.of(45))).isEqualTo(LottoRank.FIFTH);
        assertThat(lottoTicket.rank(lottoNumbersMatch2, LottoNumber.of(45))).isEqualTo(LottoRank.LOSE);
        assertThat(lottoTicket.rank(lottoNumbersMatch1, LottoNumber.of(45))).isEqualTo(LottoRank.LOSE);
        assertThat(lottoTicket.rank(lottoNumbersMatch0, LottoNumber.of(45))).isEqualTo(LottoRank.LOSE);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("당첨번호와 보너스번호가 중복")
    void duplicate_winNumbersAndBonusNumber(int bonusNumber) {
        // given
        Set<LottoNumber> lottoNumberList = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::of).collect(Collectors.toSet());
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        // when
        Set<LottoNumber> winNumberList = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::of).collect(Collectors.toSet());
        LottoNumbers winNumbers = new LottoNumbers(winNumberList);

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoTicket.rank(winNumbers, LottoNumber.of(bonusNumber)))
                .withMessageMatching("보너스 번호와 당첨번호가 중복됩니다.");
    }
}