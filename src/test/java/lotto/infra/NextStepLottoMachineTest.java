package lotto.infra;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("넥스트 스탭 로또 기계(LottoMachine) 테스트")
public class NextStepLottoMachineTest {

    private LottoMachine nextStepLottoMachine;

    @BeforeEach
    void setUp() {
        nextStepLottoMachine = new NextStepLottoMachine();
    }

    @DisplayName("구매 가능한 만큼 수동과 자동으로 로또 티켓을 생성할 수 있다. (구분자: ', ', 로또 띠켓 가격: 1000)")
    @ParameterizedTest
    @CsvSource(value = {"10000,10", "8500,8", "3000,3"})
    void generate(long amount, int expected) {
        // given
        List<String> manualNumbers = Arrays.asList(
                "1, 2, 3, 4, 5, 6",
                "2, 3, 4, 5, 6, 7",
                "3, 4, 5, 6, 7, 8"
        );

        // when
        LottoTickets lottoTickets = nextStepLottoMachine.generate(amount, manualNumbers);

        // then
        assertThat(lottoTickets.count()).isEqualTo(expected);
        System.out.println(lottoTickets);
    }

    @DisplayName("당첨 티켓과 보너스번호를 추가로 받아 우승 로또를 만들 수 있다.")
    @Test
    void winning() {
        // given
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        String bonusNumber = "7";

        // when
        WinningLotto winning = nextStepLottoMachine.winning(winningNumbers, bonusNumber);

        // then
        assertThat(winning).isNotNull();
    }
}
