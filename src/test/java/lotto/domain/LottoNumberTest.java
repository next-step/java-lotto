package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * Created by seungwoo.song on 2022-10-21
 */
class LottoNumberTest {

    @Test
    void 생성() {
        LottoNumber lottoNumber = LottoNumber.of(7);
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(7));
    }

    @Test
    void 생성_invalid() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(0));
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(46));
    }

    @Test
    void 비교() {
        assertThat(LottoNumber.of(1)).isLessThan(LottoNumber.of(3));
        assertThat(LottoNumber.of(3)).isGreaterThan(LottoNumber.of(2));
    }

    @Test
    void 정렬() {
        List<LottoNumber> list = new ArrayList<>();
        list.add(LottoNumber.of(2));
        list.add(LottoNumber.of(1));
        Collections.sort(list);

        assertThat(list).isEqualTo(List.of(LottoNumber.of(1), LottoNumber.of(2)));
    }
}