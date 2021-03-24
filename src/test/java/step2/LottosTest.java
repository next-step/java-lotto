package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    @DisplayName("Lottos 일급 컬렉션 생성 테스트")
    void 일급_컬렉션_생성_테스트(){
        Lotto lotto = new Lotto(new LottoNumber(3));
        Lotto lotto2 = new Lotto(new LottoNumber(5));
        Lotto lotto3 = new Lotto(new LottoNumber(7));
        Lotto lotto4 = new Lotto(new LottoNumber(9));
        Lotto lotto5 = new Lotto(new LottoNumber(11));
        Lotto lotto6 = new Lotto(new LottoNumber(13));

        Lottos lottos = new Lottos(Arrays.asList(lotto,lotto2,lotto3,lotto4,lotto5,lotto6));

        assertThat(lottos.getLottos()
                .stream()
                .map(lo->lo.getLottoNumber())
        ).contains(new LottoNumber(3),new LottoNumber(5),new LottoNumber(7),
                    new LottoNumber(9),new LottoNumber(11),new LottoNumber(13));
    }
}
