package step2.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("로또")
public class LottoTest {

    @DisplayName("당첨번호 갯수")
    @Test
    public void findWinningNumbersCount() {
        Lotto lotto = new Lotto(Lists.newArrayList(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(new int[] { 1, 2, 3, 4, 5 ,6 });
        assertThat(lotto.findWinningNumbersCount(winningNumbers)).isEqualTo(6);
    }

    @DisplayName("생성 테스트")
    @Test
    public void create() {
        assertThatCode(() -> new Lotto(Lists.newArrayList(1, 2, 3, 4, 5, 6))).doesNotThrowAnyException();
    }

    @DisplayName("생성 테스트")
    @Test
    public void createAndThrowIllegalException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(Lists.newArrayList(1, 2, 3, 4, 5)));
    }

}
