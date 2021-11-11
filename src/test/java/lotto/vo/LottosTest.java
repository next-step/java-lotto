package lotto.vo;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
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
                Lotto.create(Arrays.asList(
                        LottoNumber.create(1),
                        LottoNumber.create(2),
                        LottoNumber.create(3),
                        LottoNumber.create(4),
                        LottoNumber.create(5),
                        LottoNumber.create(6)
                ))
        );
        Lottos lottos = Lottos.create(lottoList);
        List<Lotto> actual = lottos.getLottoList();


        assertThat(actual).isNotSameAs(lottoList);
        assertThat(actual).isEqualTo(lottoList);

        actual.add(Lotto.create(Arrays.asList(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(6))));
        
        assertThat(actual.size()).isNotEqualTo(lottoList.size());
    }

}
