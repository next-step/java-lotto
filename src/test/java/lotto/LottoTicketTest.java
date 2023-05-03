package lotto;

import lotto.domain.LottoTicket;
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
        assertThat(firstPlaceTicket.getRank(winningLottoNumbers, bonusNumber)).isEqualTo(Rank.FIRST_PLACE);
        assertThat(secondPlaceTicket.getRank(winningLottoNumbers, bonusNumber)).isEqualTo(Rank.SECOND_PLACE);
        assertThat(thirdPlaceTicket.getRank(winningLottoNumbers, bonusNumber)).isEqualTo(Rank.THIRD_PLACE);
        assertThat(fourthPlaceTicket.getRank(winningLottoNumbers, bonusNumber)).isEqualTo(Rank.FOURTH_PLACE);
        assertThat(bonusPlaceTicket.getRank(winningLottoNumbers, bonusNumber)).isEqualTo(Rank.BONUS_PLACE);
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
    void 티켓_생성_테스트() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(LottoTicket.of(() -> Arrays.asList(1, 2, 3, 4, 5, 6)).getLottoNumbers().containsAll(numbers)).isTrue();
    }

    @Test
    void 보너스_당첨_테스트() {
        assertThat(bonusPlaceTicket.isBonusWin(winningLottoNumbers, bonusNumber)).isTrue();
    }

}
