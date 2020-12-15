package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningTicketTest {

    private WinningTicket winningTicket;
    private Set<LottoNumber> lottoNumbers;

    @BeforeEach
    void setUp() {
        this.lottoNumbers = new HashSet<>(
              Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                    , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        String numbers = "1, 2, 3, 4, 5, 6";
        String bonus = "7";
        this.winningTicket = new WinningTicket(numbers, bonus);
    }

    @DisplayName("정상생성")
    @Test
    void create() {
        //when, then
        HashSet<LottoNumber> lottoNumbers = new HashSet<>(
              Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                    , new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        WinningTicket expected = new WinningTicket(lottoNumbers, new LottoNumber(7));
        assertThat(winningTicket).isEqualTo(expected);
    }

    @DisplayName("생성오류 - 보너스 번호가 당첨번호랑 중복된 경우")
    @Test
    void create_exception() {
        //given
        String numbers = "1, 2, 3, 4, 5, 6";
        String bonus = "5";

        //when,then
        assertThatIllegalArgumentException()
              .isThrownBy(() -> new WinningTicket(numbers, bonus))
              .withMessage("보너스 번호가 당첨번호와 중복됩니다.");
    }

    @DisplayName("당첨개수 확인 - 5개 + 보너스")
    @Test
    void match() {
        //given
        HashSet<LottoNumber> userLottoNumbers = new HashSet<>(
              Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
                    , new LottoNumber(4), new LottoNumber(5), new LottoNumber(7)));
        LottoTicket lottoTicket = new LottoTicket(userLottoNumbers);

        //when
        MatchCount matchCount = this.winningTicket.match(lottoTicket);

        //then
        assertThat(matchCount).isEqualTo(MatchCount.SECOND_WITH_BONUS);
    }
}
