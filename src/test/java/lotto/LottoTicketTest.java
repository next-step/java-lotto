package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketTest {

    @Test
    @DisplayName("로또는 생성될때 숫자 6자리를 입력 받아 생성된다.")
    void lottoCreateTest() {
        var lotto = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));

        Assertions.assertThat(lotto).isInstanceOf(LottoTicket.class);
    }

    @Test
    @DisplayName("로또의 자릿수 이상의 갯수의 숫자를 받을 수 없다.")
    void lottoCreateNumbersSizeTest2() {
        var lessCase = IntStream.range(0, LottoNumber.DIGIT - 1).boxed().collect(Collectors.toUnmodifiableList());
        var moreCase = IntStream.range(0, LottoNumber.DIGIT + 1).boxed().collect(Collectors.toUnmodifiableList());

        Assertions.assertThatThrownBy(() -> new LottoTicket(lessCase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또는 " + LottoNumber.DIGIT + "자리여야 합니다.");

        Assertions.assertThatThrownBy(() -> new LottoTicket(moreCase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또는 " + LottoNumber.DIGIT + "자리여야 합니다.");
    }

    @Test
    @DisplayName("당첨번호를 통해서 몇개 맞추었는지 확인한다.")
    void lottoMatchTest() {
        var lotto = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        var winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        var result = lotto.countMatches(winningNumbers);

        Assertions.assertThat(result).isEqualTo(6L);
    }
}
