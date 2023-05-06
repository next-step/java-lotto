package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 티켓 테스트")
class LottoTicketTest {

    @DisplayName("로또 티켓 번호는 서로 다른 번호 6개로 생성하지 않으면 실패한다")
    @Test
    void createLottoTicket_fail() {
        Set<LottoNumber> numbers = new TreeSet<>();
        numbers.add(new LottoNumber(1));
        numbers.add(new LottoNumber(2));
        numbers.add(new LottoNumber(3));
        numbers.add(new LottoNumber(4));
        numbers.add(new LottoNumber(5));
        numbers.add(new LottoNumber(5));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(numbers))
                .withMessage("로또는 6개의 번호로 이루어져야 합니다");
    }

    @ParameterizedTest(name = "로또 티켓 번호는 서로 다른 번호 6개로 생성하면 성공한다")
    @CsvSource({
            "1, 2, 3, 4, 5, 6",
            "10, 20, 30, 40, 41, 42",
            "5, 10, 15, 20, 25, 30"
    })
    void createLottoTicket_Success(int num1, int num2, int num3, int num4, int num5, int num6) {
        Set<Integer> numbers = Set.of(num1, num2, num3, num4, num5, num6);

        LottoTicket lottoTicket = LottoTicket.from(numbers);

        numbers.forEach(number ->
                assertThat(
                        lottoTicket.getLottoNumbers()
                                .stream()
                                .anyMatch(lottoNumber -> lottoNumber.findLottoNumber() == number)).isTrue()
        );
    }

    @ParameterizedTest(name = "로또 티켓에 포함되어 있는 번호를 전달하면 True 를 리턴한다")
    @ValueSource(ints = {2, 5, 11, 19, 37, 45})
    void whenContainsLottoNumber_thenReturnTrue(int number) {
        LottoTicket lottoTicket = LottoTicket.from(Set.of(2, 5, 11, 19, 37, 45));

        assertThat(lottoTicket.containsLottoNumber(new LottoNumber(number))).isTrue();
    }

    @ParameterizedTest(name = "로또 티켓에 포함되어 없는 번호를 전달하면 False 를 리턴한다")
    @ValueSource(ints = {3, 8, 15, 28, 33, 41})
    void whenDoseNotContainsLottoNumber_thenReturnFalse(int number) {
        LottoTicket lottoTicket = LottoTicket.from((Set.of(2, 5, 11, 19, 37, 45)));

        assertThat(lottoTicket.containsLottoNumber(new LottoNumber(number))).isFalse();
    }

    @DisplayName("로또 티켓에서 보너스 번호가 포함되어 있는지 확인 할 수 있다")
    @Test
    void matchesBonusNumberInLottoTicket() {
        LottoTicket lottoTicket = LottoTicket.from((Set.of(1, 2, 3, 4, 5, 6)));
        assertThat(lottoTicket.matchesBonusNumber(new BonusNumber(6))).isTrue();
        assertThat(lottoTicket.matchesBonusNumber(new BonusNumber(8))).isFalse();
    }
}
