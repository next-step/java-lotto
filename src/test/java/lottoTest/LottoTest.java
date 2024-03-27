package lottoTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.Lotto;
import lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    @DisplayName("하나의 복권 당 숫자 갯수는 6개가 아니면 IllegalArgumentException.")
    void ONE_LOTTO_HAS_SIX_LOTTO_NUMBER() {
        assertThatThrownBy(() -> {
            new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6),
                new LottoNumber(7)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 숫자가 있으면 IllegalArgumentException.")
    void LOTTO_HAS_DUPLICATED_NUMBER_THEN_EXCEPTION() {
        assertThatThrownBy(() -> {
            new Lotto(List.of(new LottoNumber(11), new LottoNumber(4), new LottoNumber(8),
                new LottoNumber(34), new LottoNumber(11), new LottoNumber(43)));
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("당첨번호와 일치하는 숫자의 갯수 return")
    void COMPARE_WINNING_LOTTO_THEN_RETURN_MATCH_COUNT() {
        Lotto lotto = new Lotto(new String[] {"1","2","3","4","5","6"});

        Lotto winningLotto = new Lotto(new String[] {"1","2","3","4","5","6"});

        assertThat(lotto.countMatch(winningLotto)).isEqualTo(6);
    }

}
