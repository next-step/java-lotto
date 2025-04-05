package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTickets;
import lotto.domain.RandomNumberGeneration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("구입 장수만큼 로또를 자동생성한다")
    void autoIssueTest() {
        //given
        int purchaseAmount = 14;
        LottoMachine lottoMachine = new LottoMachine(new RandomNumberGeneration());

        //when`
        LottoTickets tickets = lottoMachine.issueAuto(purchaseAmount);

        //then
        assertThat(tickets.size()).isEqualTo(14);
    }

    @Test
    @DisplayName("입력된 만큼 로또를 수동생성한다")
    void manualIssueTest() {
        //given
        LottoMachine lottoMachine = new LottoMachine(new RandomNumberGeneration());
        Set<LottoNumber> numbers = toLottoNumbers(1, 2, 3, 4, 5, 6);
        List<Set<LottoNumber>> numbersSets = List.of(numbers);

        //when`
        LottoTickets tickets = lottoMachine.issueManual(numbersSets);

        //then
        assertThat(tickets.size()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("구입 금액이 1000원 보다 적은 경우 에러를 던진다")
    @ValueSource(ints = {-1, 0})
    void calculatePurchaseQuantityWithInvalidAmount(int purchaseAmount) {
        //given
        LottoMachine lottoMachine = new LottoMachine(new RandomNumberGeneration());

        //when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoMachine.issueAuto(purchaseAmount))
                .withMessageContaining("유효하지 않는 구입 장수입니다: ");

    }

    private static Set<LottoNumber> toLottoNumbers(Integer... numbers) {
        return Arrays.stream(numbers)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }
}