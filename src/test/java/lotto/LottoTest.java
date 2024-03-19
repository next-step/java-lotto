package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 객체 생성시 정렬 테스트")
    void makeLotto() {
        List<Integer> lottoNumbers = List.of(20,32,44,30,1);
        Lotto lotto = new Lotto(new LottoNumbers(lottoNumbers));
        assertThat(lotto.getLottoNumber().getLottoNumbers().get(0)).isEqualTo(1);
    }

}
