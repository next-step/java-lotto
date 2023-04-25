package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGeneratorTest {

    @Test
    void 로또번호_생성_범위_테스트() {
        //given
        Lotto lotto = LottoGenerator.generateLotto();

        //when
        List<Integer> lottoNumbers = lotto.numbers;

        //then
        assertThat(lottoNumbers.stream().allMatch(v -> v >= 1 && v <= 45)).isTrue();
    }


}
