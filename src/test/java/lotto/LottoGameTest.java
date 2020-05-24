package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoGameTest {

    private LottoGame lottoGame = new LottoGame();
    private int[] winningNumbers;
    private int round = 1;

    @BeforeEach
    void setUp(){
        winningNumbers = new int[]{1,2,3,4,5,6};
    }

    @Test
    @DisplayName("로또 게임을 생성하는데 어떤 예외도 발생하지 않는다.")
    void 로또_게임_생성_테스트(){
        assertThatCode(() -> new LottoGame()).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 게임을 추가하고, 결과 값을 검증한다.")
    void 로또_게임_추가_테스트(){
        lottoGame.add(round, winningNumbers);
        Lotto lotto = lottoGame.get(round);
        assertThat(lotto.getLottoNumbers()).hasSize(winningNumbers.length);
    }

    @MethodSource("generate_lotto_tickets")
    @ParameterizedTest
    @DisplayName("로또 게임 1회차의 당첨 개수를 검증한다.")
    void 로또_게임_당첨_갯수_테스트(Lotto lotto, int expected){
        int count = lottoGame.matchingCount(round, lotto);
        assertThat(count).isEqualTo(expected);
    }

    private static Stream<Arguments> generate_lotto_tickets() {
        return Stream.of(
                Arguments.of(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)), 6),
                Arguments.of(Lotto.of(Arrays.asList(23, 45, 32, 14, 2, 3, 7)), 2),
                Arguments.of(Lotto.of(Arrays.asList(23, 45, 32, 14, 2, 3, 7)), 4)
        );
    }
}
