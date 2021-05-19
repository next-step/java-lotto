package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoTicketTest {
    @DisplayName("하나의 로또에 숫자가 6개 미만일경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4", "3,4,5", "1", "9,2,3,4,5"})
    void lottoTicketConstructor(String numbers) {
        List<Integer> numberList = new ArrayList(Arrays.asList(numbers.split(",")));
        assertThatThrownBy(() -> {
            new LottoTicket(numberList);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("로또는 6자리 숫자로 구성되어야합니다.");
    }
}