package step2.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

class LottoTest {

    @Test
    public void setPrizeTest() {
        //given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(winningNumbers);

        //when
        ReflectionTestUtils.invokeMethod(lotto, "setPrize", winningNumbers);

        //then
        assertThat(lotto.getPrize()).isEqualTo(Prize.FIRST.getGrade());
    }
}