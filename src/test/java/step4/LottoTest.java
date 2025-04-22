package step4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4.domain.Lotto;
import step4.domain.LottoNumbers;
import step4.domain.MatchResult;

public class LottoTest {
    @Test
    @DisplayName("로또 번호 비교 로직 테스트")
    public void compareTest() {
        LottoNumbers source = LottoNumbers.ofManual("1, 2, 3, 4, 5, 6");
        LottoNumbers target = LottoNumbers.ofManual("1, 2, 3, 4, 5, 7");
        Lotto sourceLotto = new Lotto(source);
        MatchResult match = sourceLotto.match(target, 8);
        assertThat(match).isEqualTo(new MatchResult(5, false));
    }
}
