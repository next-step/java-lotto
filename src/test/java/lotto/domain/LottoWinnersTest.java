package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("당첨 번호 세팅")
public class LottoWinnersTest {

    public List<Integer> createLottoNumber() {
        return IntStream.range(1,7)
                .boxed()
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("당첨번호와 보너스번호 중복 테스트")
    public void winnerNumberMatchOfBonusExceptionTest() throws Exception {
        //given
        LottoNumbers winner = new LottoNumbers(createLottoNumber());
        LottoNumber bonus = new LottoNumber(1);

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoWinners(winner, bonus);
        });

        //then
    }
}
