package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by seungwoo.song on 2022-10-06
 */
class DefaultLottoNumberProduceStrategyTest {

    @Test
    void 생성() {
        DefaultLottoNumberProduceStrategy defaultLottoNumberProduceStrategy = new DefaultLottoNumberProduceStrategy(() -> 5, 1);
        List<Integer> lottoNumber = defaultLottoNumberProduceStrategy.getLottoNumber();

        assertThat(lottoNumber).isEqualTo(List.of(5));
    }
}