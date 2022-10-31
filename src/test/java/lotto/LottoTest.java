package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @Test
    @DisplayName("로또 자동 추출")
    void test1() {
        // given
        // when
        Lotto lotto1 = Lotto.auto(() -> List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = Lotto.auto(() -> List.of(1, 2, 3, 4, 5, 6));
        // then
        assertThat(lotto1).isEqualTo(lotto2);
    }

    @Test
    @DisplayName("로또 자동 번호 7개")
    void test2() {
        // given
        // when
        // then
        assertThatThrownBy(() -> {
            Lotto.auto(() -> List.of(1, 2, 3, 4, 5, 6, 7));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 유효숫자 벗어남")
    void test3() {
        // given
        // when
        // then
        assertThatThrownBy(() -> {
            Lotto.auto(() -> List.of(1, 2, 3, 4, 5, 99));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 수동 추출")
    void test4() {
        // given
        // when
        Lotto lotto1 = Lotto.manual(1, 2, 3, 4, 5, 6);
        Lotto lotto2 = Lotto.manual(6, 5, 4, 3, 2, 1);
        // then
        assertThat(lotto1).isEqualTo(lotto2);
    }

    @Test
    @DisplayName("로또 수동번호가 범위를 벗어남")
    void test5() {
        // given
        // when
        // then
        assertThatThrownBy(() -> {
            Lotto.manual(-1, 2, 3, 4, 5, 99);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 숫자 매칭")
    void test6() {
        // given
        Lotto lotto1 = Lotto.manual(1, 2, 3, 4, 5, 6);
        Lotto lotto2 = Lotto.manual(1, 2, 3, 4, 5, 7);
        // when
        int count = lotto1.matchCount(lotto2);
        // then
        assertThat(count).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 숫자 매칭 한개")
    void test7() {
        // given
        Lotto lotto = Lotto.manual(1, 2, 3, 4, 5, 6);
        LottoNumber lottoNumber = LottoNumber.of(1);
        // when
        int count = lotto.matchCount(lottoNumber);
        // then
        assertThat(count).isEqualTo(1);
    }

}
