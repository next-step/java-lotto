package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTicketTest {
    @DisplayName("여섯개의 숫자를 받아 로또티켓 생성")
    @Test
    void newInstance() {
        //given
        List<Integer> lottoNumbers = Arrays.asList(8, 21, 23, 41, 42, 43);

        //when
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        //then
        assertThat(lottoTicket).isNotNull();
    }

    @DisplayName("로또번호가 아닌 숫자인경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "46,1,2,3,4,5"})
    void newInstanceWithWrongNumber(String numbers) {
        //given
        List<Integer> lottoNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(lottoNumbers))
                .withMessage("잘못된 로또 번호입니다.");
    }

    @DisplayName("중복된 번호인경우 에러를 발생시킨다.")
    @Test
    void newInstanceWithDuplicatedNumber() {
        //given
        List<Integer> lottoNumbers = Arrays.asList(1, 1, 2, 3, 4, 5);

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(lottoNumbers))
                .withMessage("중복된 번호가 존재합니다.");
    }
}
