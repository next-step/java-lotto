package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-14
 */
class LottoNumbersTest {

    @Test
    void 생성() {
        LottoNumbers lottoNumbers = new LottoNumbers();

        assertThat(lottoNumbers).isEqualTo(new LottoNumbers());
    }

    @Test
    void 섞기() {
        LottoNumbers lottoNumbers = new LottoNumbers();

        lottoNumbers.shuffle(numbers -> {
        });

        List<Integer> limited = lottoNumbers.get()
                .stream()
                .limit(6)
                .collect(Collectors.toList());

        assertThat(limited).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}