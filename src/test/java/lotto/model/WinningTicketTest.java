package lotto.model;

import lotto.exception.InvalidLottoTicketException;
import lotto.model.lotto.LottoNumber;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.WinningTicket;
import lotto.model.rank.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningTicketTest {

    private WinningTicket winningTicket;

    @BeforeEach
    void setUp() {
        winningTicket = initWinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);
    }

    private WinningTicket initWinningNumber(List<Integer> numbers, int bonusNumber) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        LottoTicket winningTicket = new LottoTicket(new HashSet<>(lottoNumbers));
        LottoNumber bonusLottoNumber = new LottoNumber(bonusNumber);

        return new WinningTicket(winningTicket, bonusLottoNumber);
    }

    @Test
    @DisplayName("우승 티켓이 정상적으로 생성된다")
    void createWinningTicket() {
        assertThat(winningTicket).isInstanceOfAny(WinningTicket.class);
    }

    @Test
    @DisplayName("로또 넘버가 6개가 아니면 당첨 티켓을 생성할 수 없다")
    void failValidationOfWinningTicket() {
        assertThatThrownBy(() -> new WinningTicket(
                new LottoTicket(Set.of(new LottoNumber(2), new LottoNumber(3))),
                new LottoNumber(4))
        ).isInstanceOf(InvalidLottoTicketException.class);
    }

    @Test
    @DisplayName("일치하는 숫자에 따라 등수를 반환한다")
    void getRank() {
        //given
        LottoTicket lottoTicket = new LottoTicket(
                Set.of(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(7),
                        new LottoNumber(8)
                )
        );

        //when
        Rank rank = winningTicket.drawLotto(lottoTicket);

        //then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

}