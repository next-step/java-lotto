package lotto.cod;

import lotto.code.MatchedNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MatchedNumberTest {

    @Test
    void findByNumber() {
        assertThat(MatchedNumber.findByNumber(3)).isEqualTo(MatchedNumber.THREE);
        assertThat(MatchedNumber.findByNumber(4)).isEqualTo(MatchedNumber.FOUR);
        assertThat(MatchedNumber.findByNumber(5)).isEqualTo(MatchedNumber.FIVE);
        assertThat(MatchedNumber.findByNumber(6)).isEqualTo(MatchedNumber.SIX);
        assertThatIllegalArgumentException().isThrownBy(() -> MatchedNumber.findByNumber(7))
                .withMessageMatching("없는 일치 번호 입니다.");
    }

}
