package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.WinningTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WinningTicketTest {
    List<LottoNumber> winningNumbers = new ArrayList<>();
    LottoNumber bonusNumber = new LottoNumber(7);

    @BeforeEach
    void setUp() {
        winningNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @DisplayName("로또 당첨번호와 보너스볼은 중복될 수 없다.")
    @Test
    void createFail() {
        LottoNumber duplicatedBonusNumber = new LottoNumber(1);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningTicket(winningNumbers, duplicatedBonusNumber))
                .withMessageMatching("보너스볼은 당첨번호와 중복될 수 없습니다.");
    }

    @DisplayName("당첨번호와 일치하는 번호의 수를 구할 수 있다.")
    @Test
    void matchesWinningNumbers() {
        List<LottoNumber> allMatchesNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        WinningTicket winningTicket = new WinningTicket(winningNumbers, bonusNumber);
        assertThat(winningTicket.calculateMatchesCount(allMatchesNumbers)).isEqualTo(6);
    }

    @DisplayName("보너스 번호와 로또 번호들의 일치여부를 구할 수 있다.")
    @Test
    void matchesBonus() {
        List<LottoNumber> containsBonusNumber = IntStream.rangeClosed(2, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        WinningTicket winningTicket = new WinningTicket(winningNumbers, bonusNumber);
        assertThat(winningTicket.matchesBonus(containsBonusNumber)).isTrue();
    }
}
