package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by seungwoo.song on 2022-10-06
 */
class RandomStrategyTest {

    @Test
    void 생성() {
        RandomStrategy randomStrategy = new RandomStrategy(() -> 5, 1);
        List<Integer> lottoNumber = randomStrategy.getLottoNumber();

        assertThat(lottoNumber).isEqualTo(List.of(5));
    }
}