package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 티켓 테스트")
class LottoTicketTest {

    @DisplayName("로또 티켓 번호는 서로 다른 번호 6개로 생성하지 않으면 실패한다")
    @Test
    void createLottoTicket_fail() {
        Set<LottoNumber> numbers = new TreeSet<>(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(5)
        ));

        Assertions.assertThatIllegalArgumentException()
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
        Set<LottoNumber> numbers = new TreeSet<>();
        numbers.add(new LottoNumber(num1));
        numbers.add(new LottoNumber(num2));
        numbers.add(new LottoNumber(num3));
        numbers.add(new LottoNumber(num4));
        numbers.add(new LottoNumber(num5));
        numbers.add(new LottoNumber(num6));

        LottoTicket lottoTicket = new LottoTicket(numbers);

        assertEquals(numbers, lottoTicket.getLottoNumbers());
    }

    @ParameterizedTest(name = "로또 티켓에 포함되어 있는 번호를 전달하면 True 를 리턴한다")
    @ValueSource(ints = {2, 5, 11, 19, 37, 45})
    void whenContainsLottoNumber_thenReturnTrue(int number){
        Set<LottoNumber> numbers = new HashSet<>(Arrays.asList(
                new LottoNumber(2),
                new LottoNumber(5),
                new LottoNumber(11),
                new LottoNumber(19),
                new LottoNumber(37),
                new LottoNumber(45)
        ));

        LottoTicket lottoTicket = new LottoTicket(numbers);

        Assertions.assertThat(lottoTicket.containsLottoNumber(new LottoNumber(number))).isTrue();
    }

    @ParameterizedTest(name = "로또 티켓에 포함되어 없는 번호를 전달하면 False 를 리턴한다")
    @ValueSource(ints = {3, 8, 15, 28, 33, 41})
    void whenDoseNotContainsLottoNumber_thenReturnFalse(int number){
        Set<LottoNumber> numbers = new TreeSet<>(Arrays.asList(
                new LottoNumber(2),
                new LottoNumber(5),
                new LottoNumber(11),
                new LottoNumber(19),
                new LottoNumber(37),
                new LottoNumber(45)
        ));

        LottoTicket lottoTicket = new LottoTicket(numbers);

        Assertions.assertThat(lottoTicket.containsLottoNumber(new LottoNumber(number))).isFalse();
    }

}