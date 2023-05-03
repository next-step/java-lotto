package lotto;

import lotto.domain.LottoTicket;
import lotto.dto.CheckWinningRequest;
import lotto.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketTest {
    List<Integer> winningLottoNumbers;

    int bonusNumber;
    LottoTicket firstPlaceTicket;
    LottoTicket secondPlaceTicket;
    LottoTicket thirdPlaceTicket;
    LottoTicket fourthPlaceTicket;
    LottoTicket bonusPlaceTicket;

    @BeforeEach
    void setUp() {
        bonusNumber = 7;
        winningLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        firstPlaceTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        secondPlaceTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 9));
        thirdPlaceTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 8, 9));
        fourthPlaceTicket = new LottoTicket(Arrays.asList(1, 2, 3, 10, 8, 9));
        bonusPlaceTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7));
    }

    @Test
    void 당첨_확인_테스트() {
        assertThat(firstPlaceTicket.countSameNumber(winningLottoNumbers)).isEqualTo(6);
        assertThat(secondPlaceTicket.countSameNumber(winningLottoNumbers)).isEqualTo(5);
        assertThat(thirdPlaceTicket.countSameNumber(winningLottoNumbers)).isEqualTo(4);
        assertThat(fourthPlaceTicket.countSameNumber(winningLottoNumbers)).isEqualTo(3);
    }

    @Test
    void 등수_확인() {
        CheckWinningRequest checkWinningRequest = new CheckWinningRequest(winningLottoNumbers, bonusNumber);
        assertThat(firstPlaceTicket.getRank(checkWinningRequest)).isEqualTo(Rank.FIRST_PLACE);
        assertThat(secondPlaceTicket.getRank(checkWinningRequest)).isEqualTo(Rank.SECOND_PLACE);
        assertThat(thirdPlaceTicket.getRank(checkWinningRequest)).isEqualTo(Rank.THIRD_PLACE);
        assertThat(fourthPlaceTicket.getRank(checkWinningRequest)).isEqualTo(Rank.FOURTH_PLACE);
        assertThat(bonusPlaceTicket.getRank(checkWinningRequest)).isEqualTo(Rank.BONUS_PLACE);
    }

    @Test
    void 번호갯수_검증() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2);

        assertThatIllegalArgumentException().isThrownBy(() ->
                LottoTicket.validateTicketSize(lottoNumbers)
        ).withMessage("로또번호는 6개를 입력하셔야합니다");
    }

    @Test
    void 번호_범위_검증() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);
        assertThatIllegalArgumentException().isThrownBy(() ->
                LottoTicket.validateLottoNumberRange(lottoNumbers)
        ).withMessage("로또번호는 1~45 사이의 숫자로 입력해야합니다.");
    }


    @Test
    void 보너스_당첨_테스트() {
        assertThat(bonusPlaceTicket.isBonusWin(new CheckWinningRequest(winningLottoNumbers, bonusNumber))).isTrue();
    }

}
