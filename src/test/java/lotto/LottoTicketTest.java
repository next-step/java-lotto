package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
            LottoNumber bonusNumber = LottoNumber.of(23);

            // When
            assertThat(lottoTicket.getRank(new WinLotto(winLottoTicket, bonusNumber))).isEqualTo(Rank.FIFTH);
        }

        @Test
        @DisplayName("[성공] 당첨 번호와 4개 일치하면 Rank.FOURTH 를 리턴한다.")
        void 당첨_4개() {
            // Given
            LottoTicket lottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
            LottoTicket winLottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 44, 45)));
            LottoNumber bonusNumber = LottoNumber.of(23);

            // When
            assertThat(lottoTicket.getRank(new WinLotto(winLottoTicket, bonusNumber))).isEqualTo(Rank.FOURTH);
        }

        @Test
        @DisplayName("[성공] 당첨 번호와 모두 일치하면 Rank.FIRST 를 리턴한다.")
        void 모두_일치() {
            // Given
            LottoTicket lottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
            LottoTicket winLottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
            LottoNumber bonusNumber = LottoNumber.of(23);

            // When
            assertThat(lottoTicket.getRank(new WinLotto(winLottoTicket, bonusNumber))).isEqualTo(Rank.FIRST);
        }

        @Test
        @DisplayName("[성공] 당첨 번호와 2개 일치하면 (로또 등수에 해당되지 않는 당첨 번호 개수를 입력) Rank.MISS 를 리턴한다.")
        void 불일치() {
            // Given
            LottoTicket lottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
            LottoTicket winLottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 42, 43, 44, 45)));
            LottoNumber bonusNumber = LottoNumber.of(23);

            // When
            assertThat(lottoTicket.getRank(new WinLotto(winLottoTicket, bonusNumber))).isEqualTo(Rank.MISS);
        }

        @Test
        @DisplayName("[성공] 당첨 번호와 5개 일치하면 Rank.THIRD 를 리턴한다.")
        void 당첨_5개() {
            // Given
            LottoTicket lottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
            LottoTicket winLottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 45)));
            LottoNumber bonusNumber = LottoNumber.of(23);

            // When
            assertThat(lottoTicket.getRank(new WinLotto(winLottoTicket, bonusNumber))).isEqualTo(Rank.THIRD);
        }

        @Test
        @DisplayName("[성공] 당첨 번호와 5개 일치하고 보너스 번호와 일치하면 Rank.SECOND 를 리턴한다.")
        void 당첨_5개_보너스() {
            // Given
            LottoTicket lottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 23)));
            LottoTicket winLottoTicket = new LottoTicket(new LottoNumbers(List.of(1, 2, 3, 4, 5, 45)));
            LottoNumber bonusNumber = LottoNumber.of(23);

            // When
            assertThat(lottoTicket.getRank(new WinLotto(winLottoTicket, bonusNumber))).isEqualTo(Rank.SECOND);
        }

    }

}
