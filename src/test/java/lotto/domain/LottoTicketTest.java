package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.LottoNumber.*;
import static lotto.domain.Rank.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class LottoTicketTest {

    @Test
    void 로또_생성_사이즈() {
        List<Integer> zeroSizeList = new ArrayList<>();
        Assertions.assertThatThrownBy(() -> new LottoTicket(zeroSizeList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_생성_중복번호() {
        List<Integer> duplicateNumberList = List.of(1, 1, 2, 3, 4, 5);
        Assertions.assertThatThrownBy(() -> new LottoTicket(duplicateNumberList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("당첨번호를 전달받아서 등수 반환")
    void match(LottoTicket lottoTicket, Rank rank) {
        List<LottoNumber> winningNumbers = List.of(valueOf(1), valueOf(2), valueOf(3),
                valueOf(4), valueOf(5), valueOf(6));
        Assertions.assertThat(lottoTicket.match(winningNumbers, LottoNumber.valueOf(7))).isEqualTo(rank);
    }

    static Stream<Arguments> match() {
        return Stream.of(
                arguments(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)), FIRST),
                arguments(new LottoTicket(List.of(1, 2, 3, 4, 5, 7)), SECOND),
                arguments(new LottoTicket(List.of(1, 2, 3, 4, 5, 8)), THIRD),
                arguments(new LottoTicket(List.of(1, 2, 3, 4, 7, 8)), FOURTH),
                arguments(new LottoTicket(List.of(1, 2, 3, 7, 8, 9)), FIFTH),
                arguments(new LottoTicket(List.of(1, 2, 7, 8, 9, 10)), NO_MATCH)
        );
    }

}
