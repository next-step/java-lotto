package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusBallTest {

    @Test
    @DisplayName("보너스 볼 생성")
    public void create() throws Exception {
        BonusBall bonusBall = new BonusBall(1);
        assertThat(bonusBall).isEqualTo(new BonusBall(1));
    }

    @Test
    @DisplayName("보너스 볼의 번호가 로또 번호에 속하는지 확인 여부")
    public void isPartOf() throws Exception {
        LottoNumbers lottoNumbers = LottoNumbers.from(Arrays.asList(1,2,3,4,5,6));
        assertThat(new BonusBall(1).isPartOf(lottoNumbers)).isTrue();
        assertThat(new BonusBall(7).isPartOf(lottoNumbers)).isFalse();
    }
}
