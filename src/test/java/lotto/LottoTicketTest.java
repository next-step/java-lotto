package lotto;

import lotto.domain.LottoTicket;
import lotto.enums.RANK;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketTest {
    List<Integer> winningLottoNumbers;
    LottoTicket firstPlaceTicket;
    LottoTicket secondPlaceTicket;
    LottoTicket thirdPlaceTicket;
    LottoTicket fourthPlaceTicket;

    @BeforeEach
    void setUp() {
        winningLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        firstPlaceTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        secondPlaceTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 9));
        thirdPlaceTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 8, 9));
        fourthPlaceTicket = new LottoTicket(Arrays.asList(1, 2, 3, 7, 8, 9));
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
        assertThat(firstPlaceTicket.getRank(winningLottoNumbers)).isEqualTo(RANK.FIRST_PLACE);
        assertThat(secondPlaceTicket.getRank(winningLottoNumbers)).isEqualTo(RANK.SECOND_PLACE);
        assertThat(thirdPlaceTicket.getRank(winningLottoNumbers)).isEqualTo(RANK.THIRD_PLACE);
        assertThat(fourthPlaceTicket.getRank(winningLottoNumbers)).isEqualTo(RANK.FOURTH_PLACE);
    }
}
