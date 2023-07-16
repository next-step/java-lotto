package lottogame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("WinningLotto 클래스")
class WinningLottoTest {

    private static final int BONUS_NUMBER = 7;
    private final Set<Integer> lottoNumbers = Set.of(1, 2, 3, 4, 5, 6);

    @Nested
    @DisplayName("new 생성자는")
    class Describe_New_Constructor {

        @Nested
        @DisplayName("lotto 번호들과, bonus 번호를 받으면,")
        class Context_Input_Bonus_And_Lotto_Numbers {

            @Test
            @DisplayName("생성한다.")
            void It_Create() {
                assertThatCode(() -> new WinningLotto(lottoNumbers, BONUS_NUMBER)).doesNotThrowAnyException();
            }
        }
    }

    @Nested
    @DisplayName("toLottoRanks 메서드는")
    class Describe_To_Lotto_Ranks {

        @Nested
        @DisplayName("LottoTickets를 받으면")
        class Context_Input_Lotto_Tickets {

            private final WinningLotto winningLotto = new WinningLotto(lottoNumbers, BONUS_NUMBER);
            private final LottoTickets lottoTickets = new LottoTickets(2, List.of(Set.of(1,2,3,4,5,6)), (count)-> Set.of(1,2,3,4,5,7));

            @Test
            @DisplayName("LottoRanks를 반환한다")
            void It_Return_Lotto_Ranks() {
                assertThat(winningLotto.toLottoRanks(lottoTickets)).isEqualTo(List.of(LottoRank.FIRST, LottoRank.SECOND));
            }
        }
    }
}
