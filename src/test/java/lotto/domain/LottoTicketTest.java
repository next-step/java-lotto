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
    void match(List<LottoNumber> winningLottoTicket, Rank rank) {
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lottoTicket.match(winningLottoTicket)).isEqualTo(rank);
    }

    static Stream<Arguments> match() {
        return Stream.of(
                arguments(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)), Rank.FIRST),
                arguments(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(7)), Rank.SECOND),
                arguments(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(8), new LottoNumber(7)), Rank.THIRD),
                arguments(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(9), new LottoNumber(8), new LottoNumber(7)), Rank.FOURTH),
                arguments(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(10),
                        new LottoNumber(9), new LottoNumber(8), new LottoNumber(7)), Rank.NO_MATCH)
        );
    }

}
