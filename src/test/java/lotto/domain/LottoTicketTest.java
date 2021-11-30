package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    private LottoTicket initTicket;

    @BeforeEach
    @DisplayName("테스트용 로또 티켓 생성")
    void setUp() {
        List<Integer> lottoNumbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers2 = Arrays.asList(1, 2, 3, 4, 10, 20);
        List<Integer> lottoNumbers3 = Arrays.asList(1, 2, 3, 10, 20, 40);

        initTicket = LottoTicket.from(Arrays.asList(Lotto.winningFrom(lottoNumbers1),
                Lotto.winningFrom(lottoNumbers2), Lotto.winningFrom(lottoNumbers3)));
    }

    @Test
    @DisplayName("로또 일급 컬랜셕 생성 테스트(수동)")
    void createTest() {
        LottoTicket lottoTicket = new LottoTicket(3);

        assertThat(lottoTicket.getLotto().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @MethodSource("provideWinnerNumberCount")
    @DisplayName("당첨번호를 입력했을 때 맞는 갯수 카운트 검증")
    void createRepository(Lotto winningNumbers, Rank key, int value) {
        Map<Rank, Integer> repository = initTicket.createRepository(winningNumbers);
        assertThat(repository.get(key)).isEqualTo(value);
    }

    private static Stream<Arguments> provideWinnerNumberCount() {
        return Stream.of(
                Arguments.of(Lotto.winningFrom(Arrays.asList(1, 2, 3, 4, 5, 6)), Rank.FIRST, 1),
                Arguments.of(Lotto.winningFrom(Arrays.asList(1, 2, 3, 4, 44, 45)), Rank.FOURTH, 2),
                Arguments.of(Lotto.winningFrom(Arrays.asList(7, 8, 9, 10, 20, 40)), Rank.FIFTH, 1)
        );
    }
}
