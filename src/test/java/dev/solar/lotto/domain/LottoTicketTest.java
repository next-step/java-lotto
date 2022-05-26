package dev.solar.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import dev.solar.lotto.domain.LottoTicket;
import dev.solar.lotto.domain.WinningLotto;

public class LottoTicketTest {
    @DisplayName("입력받은 당첨 번호로 몇개의 번호를 맞췄는지 계산한다.")
    @MethodSource("lottoNumbers")
    @ParameterizedTest
    void check_the_number_of_wins(LottoTicket lottoTicket, Rank result) {
        WinningLotto winningLotto = new WinningLotto(Set.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(winningLotto.match(lottoTicket)).isEqualTo(result);
    }

    private static Stream<Arguments> lottoNumbers() {
        return Stream.of(Arguments.of(new LottoTicket("1,2,3,4,44,45"), Rank.FOURTH),
                         Arguments.of(new LottoTicket("1,2,3,4,5,45"), Rank.THIRD),
                         Arguments.of(new LottoTicket("1,2,3,4,5,6"), Rank.FIRST));
    }
}
