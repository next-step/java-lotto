package lotto;

import lotto.domain.*;
import lotto.exception.IllegalLottoNumberException;
import lotto.exception.IllegalLottoNumbersSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTicketTest {

    @Nested
    @DisplayName("당첨 번호와 매칭")
    class MatchNumberTestCase {

        @Test
        @DisplayName("[성공] 당첨 번호와 3개 일치하면 Rank.FIFTH 를 리턴한다.")
        void 당첨_3개() {
            // Given
            LottoTicket lottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
            LottoTicket winLottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 43, 44, 45)));
            LottoNumber bonusNumber = new LottoNumber(23);

            // When
            assertThat(lottoTicket.getRank(new WinLotto(winLottoTicket, bonusNumber))).isEqualTo(Rank.FIFTH);
        }

        @Test
        @DisplayName("[성공] 당첨 번호와 4개 일치하면 Rank.FOURTH 를 리턴한다.")
        void 당첨_4개() {
            // Given
            LottoTicket lottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
            LottoTicket winLottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 44, 45)));
            LottoNumber bonusNumber = new LottoNumber(23);

            // When
            assertThat(lottoTicket.getRank(new WinLotto(winLottoTicket, bonusNumber))).isEqualTo(Rank.FOURTH);
        }

        @Test
        @DisplayName("[성공] 당첨 번호와 모두 일치하면 Rank.FIRST 를 리턴한다.")
        void 모두_일치() {
            // Given
            LottoTicket lottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
            LottoTicket winLottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
            LottoNumber bonusNumber = new LottoNumber(23);

            // When
            assertThat(lottoTicket.getRank(new WinLotto(winLottoTicket, bonusNumber))).isEqualTo(Rank.FIRST);
        }

        @Test
        @DisplayName("[성공] 당첨 번호와 2개 일치하면 (로또 등수에 해당되지 않는 당첨 번호 개수를 입력) Rank.MISS 를 리턴한다.")
        void 불일치() {
            // Given
            LottoTicket lottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
            LottoTicket winLottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 42, 43, 44, 45)));
            LottoNumber bonusNumber = new LottoNumber(23);

            // When
            assertThat(lottoTicket.getRank(new WinLotto(winLottoTicket, bonusNumber))).isEqualTo(Rank.MISS);
        }

        @Test
        @DisplayName("[성공] 당첨 번호와 5개 일치하면 Rank.THIRD 를 리턴한다.")
        void 당첨_5개() {
            // Given
            LottoTicket lottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
            LottoTicket winLottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 45)));
            LottoNumber bonusNumber = new LottoNumber(23);

            // When
            assertThat(lottoTicket.getRank(new WinLotto(winLottoTicket, bonusNumber))).isEqualTo(Rank.THIRD);
        }

        @Test
        @DisplayName("[성공] 당첨 번호와 5개 일치하고 보너스 번호와 일치하면 Rank.SECOND 를 리턴한다.")
        void 당첨_5개_보너스() {
            // Given
            LottoTicket lottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 23)));
            LottoTicket winLottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 45)));
            LottoNumber bonusNumber = new LottoNumber(23);

            // When
            assertThat(lottoTicket.getRank(new WinLotto(winLottoTicket, bonusNumber))).isEqualTo(Rank.SECOND);
        }

    }

    @Nested
    @DisplayName("로또 번호 검증")
    class LottoNumberValidateTestCase {

        @Test
        @DisplayName("[실패] 로또 번호에 0이 포함되어 있으면 IllegalLottoNumberException 예외가 발생한다.")
        void 로또_번호_범위_0포함() {
            assertThatExceptionOfType(IllegalLottoNumberException.class)
                    .isThrownBy(() -> new LottoTicket(new LottoNumbers(List.of(0, 2, 3, 4, 5, 6))));
        }

        @Test
        @DisplayName("[실패] 로또 번호에 46이 포함되어 있으면 IllegalLottoNumberException 예외가 발생한다.")
        void 로또_번호_범위_46포함() {
            assertThatExceptionOfType(IllegalLottoNumberException.class)
                    .isThrownBy(() -> new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 46))));
        }

        @Test
        @DisplayName("[실패] 로또 번호에 0과 46이 포함되어 있으면 IllegalLottoNumberException 예외가 발생한다.")
        void 로또_번호_범위_0과_46포함() {
            assertThatExceptionOfType(IllegalLottoNumberException.class)
                    .isThrownBy(() -> new LottoTicket(new LottoNumbers(List.of(0, 2, 3, 4, 5, 46))));
        }

        @Test
        @DisplayName("[실패] 로또 번호 개수가 6개가 아니면 IllegalLottoNumbersSizeException 예외가 발생한다.")
        void 로또_번호_개수() {
            assertThatExceptionOfType(IllegalLottoNumbersSizeException.class)
                    .isThrownBy(() -> new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5))));
        }

    }
}
