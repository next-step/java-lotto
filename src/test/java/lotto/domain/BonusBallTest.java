package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class BonusBallTest {

    @DisplayName("객체생성")
    @Test
    void 객체생성() {
        BonusBall bonusBall = new BonusBall(new LottoNumber(1));
        assertThat(bonusBall).isInstanceOf(BonusBall.class);
    }

    @DisplayName("보너스볼이 있으면 true")
    @Test
    void contains_포함_true() {
        BonusBall bonusBall = new BonusBall(new LottoNumber(45));
        List<LottoNumber> lottoNumbers = new ArrayList<>(Arrays.asList(new LottoNumber(45)));
        assertThat(bonusBall.contains(lottoNumbers)).isTrue();
    }

    @DisplayName("보너스볼이 없으면 false")
    @Test
    void contains_포함_false() {
        BonusBall bonusBall = new BonusBall(new LottoNumber(45));
        List<LottoNumber> lottoNumbers = new ArrayList<>(Arrays.asList(new LottoNumber(40)));
        assertThat(bonusBall.contains(lottoNumbers)).isFalse();
    }

}
