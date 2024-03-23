package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @DisplayName("로또 번호 생성기가 로또를 생성하면 6개의 숫자는 내가 지정한 숫자가 나온다")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:1", "2:2", "3:3", "4:4", "5:5"}, delimiter = ':')
    void specified_number(int input, int expected) {
        List<Integer> specifiedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = new LottoTicket(() -> specifiedNumbers);

        List<Integer> numbers = lottoTicket.generate();

        assertThat(numbers.get(input)).isEqualTo(specifiedNumbers.get(expected));
    }

    @DisplayName("로또 번호 생성기가 로또를 생성하면 6개의 숫자는 중복이 되지 않는다")
    @Test
    void duplicate_number() {
        LottoTicket lottoTicket = new LottoTicket();
        List<Integer> numbers = lottoTicket.generate();

        List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());

        assertThat(distinctNumbers.size()).isEqualTo(6);
    }

    @DisplayName("로또 번호 생성기가 로또를 생성하면 6개의 숫자를 반환한다")
    @Test
    void six_number() {
        LottoTicket lottoTicket = new LottoTicket();

        List<Integer> numbers = lottoTicket.generate();

        System.out.println("numbers = " + numbers);
        assertThat(numbers.size()).isEqualTo(6);
    }

}
