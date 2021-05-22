package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @Test
    @DisplayName("등수 조회")
    void rank() {
        // given
        List<LottoNumber> lottoNumberList = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::of).collect(Collectors.toList());
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        // when
        List<LottoNumber> lottoNumberMatch6 = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::of).collect(Collectors.toList());
        LottoNumbers lottoNumbersMatch6 = new LottoNumbers(lottoNumberMatch6);

        List<LottoNumber> lottoNumberMatch5 = Stream.of(7, 2, 3, 4, 5, 6).map(LottoNumber::of).collect(Collectors.toList());
        LottoNumbers lottoNumbersMatch5 = new LottoNumbers(lottoNumberMatch5);

        List<LottoNumber> lottoNumberMatch4 = Stream.of(7, 8, 3, 4, 5, 6).map(LottoNumber::of).collect(Collectors.toList());
        LottoNumbers lottoNumbersMatch4 = new LottoNumbers(lottoNumberMatch4);

        List<LottoNumber> lottoNumberMatch3 = Stream.of(7, 8, 9, 4, 5, 6).map(LottoNumber::of).collect(Collectors.toList());
        LottoNumbers lottoNumbersMatch3 = new LottoNumbers(lottoNumberMatch3);

        List<LottoNumber> lottoNumberMatch2 = Stream.of(7, 8, 9, 10, 5, 6).map(LottoNumber::of).collect(Collectors.toList());
        LottoNumbers lottoNumbersMatch2 = new LottoNumbers(lottoNumberMatch2);

        List<LottoNumber> lottoNumberMatch1 = Stream.of(7, 8, 9, 10, 11, 12).map(LottoNumber::of).collect(Collectors.toList());
        LottoNumbers lottoNumbersMatch1 = new LottoNumbers(lottoNumberMatch1);

        List<LottoNumber> lottoNumberMatch0 = Stream.of(7, 8, 9, 10, 11, 12).map(LottoNumber::of).collect(Collectors.toList());
        LottoNumbers lottoNumbersMatch0 = new LottoNumbers(lottoNumberMatch0);

        // then
        assertThat(lottoTicket.rank(lottoNumbersMatch6)).isEqualTo(LottoRank.FIRST);
        assertThat(lottoTicket.rank(lottoNumbersMatch5)).isEqualTo(LottoRank.THIRD);
        assertThat(lottoTicket.rank(lottoNumbersMatch4)).isEqualTo(LottoRank.FOURTH);
        assertThat(lottoTicket.rank(lottoNumbersMatch3)).isEqualTo(LottoRank.FIFTH);
        assertThat(lottoTicket.rank(lottoNumbersMatch2)).isEqualTo(LottoRank.LOSE);
        assertThat(lottoTicket.rank(lottoNumbersMatch1)).isEqualTo(LottoRank.LOSE);
        assertThat(lottoTicket.rank(lottoNumbersMatch0)).isEqualTo(LottoRank.LOSE);
    }

}