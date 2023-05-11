package lotto.code;

import lotto.common.code.MatchedNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MatchedNumberTest {

    @Test
    void findByNumberWithMatchedBonus() {
        assertThat(MatchedNumber.findByNumberWithMatchedBonus(3, false)).isEqualTo(MatchedNumber.THREE);
        assertThat(MatchedNumber.findByNumberWithMatchedBonus(4, false)).isEqualTo(MatchedNumber.FOUR);
        assertThat(MatchedNumber.findByNumberWithMatchedBonus(5, false)).isEqualTo(MatchedNumber.FIVE);
        assertThat(MatchedNumber.findByNumberWithMatchedBonus(5, true)).isEqualTo(MatchedNumber.FIVE_AND_BONUS);
        assertThat(MatchedNumber.findByNumberWithMatchedBonus(6, false)).isEqualTo(MatchedNumber.SIX);
        assertThatIllegalArgumentException().isThrownBy(() -> MatchedNumber.findByNumberWithMatchedBonus(7,false))
                .withMessageMatching("없는 일치 번호 입니다.");
    }

}
