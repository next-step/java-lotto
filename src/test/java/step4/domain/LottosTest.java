package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @DisplayName("Getter를 통해 반환된 값은 LottoList의 값은 같지만 같은 객체는 아니다.")
    @Test
    void test() {
        List<Lotto> lottoList = Arrays.asList(
                Lotto.of("1,2,3,4,5,6")
        );
        Lottos lottos = Lottos.of(lottoList);
        List<Lotto> actual = lottos.getLottoList();


        assertThat(actual).isNotSameAs(lottoList);
        assertThat(actual).isEqualTo(lottoList);

    }

}
