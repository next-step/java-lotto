package lottoauto.domain.aggregate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoShufflerTest {

    @Test
    @DisplayName("6개의 랜덤한 숫자를 반환하는지 확인하는 테스트")
    void getSizList() {
        // given
        LottoShuffler lottoShuffler = new LottoShuffler();
        // when
        List<Integer> result = lottoShuffler.makeShuffle();
        // then
        assertThat(result).hasSize(6);
    }

    @RepeatedTest(100)
    @DisplayName("6개의 랜덤한 숫자 중 1 ~ 45 외의 숫자가 있으면 안됩니다.")
    void notValidNumber() {
        // given
        LottoShuffler lottoShuffler = new LottoShuffler();
        // when
        List<Integer> result = lottoShuffler.makeShuffle();
        // then
        assertThat(result).noneMatch(num -> num < 1 || num > 45);
    }

}