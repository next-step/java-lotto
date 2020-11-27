package my.project.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.SortedSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created : 2020-11-23 오후 5:40
 * Developer : Seo
 */
class Lotto_Test {
    private Lotto_ lotto;
    private SortedSet<Integer> selected;

    @BeforeEach
    void setUp() {
        lotto = new Lotto_();
        selected = lotto.generate();
    }

    @DisplayName("선택된 번호가 6개인가")
    @Test
    void testNumberSize() {
        assertThat(selected).hasSize(6);
    }

    @DisplayName("선택된 번호가 1과 45 사이인가")
    @Test
    void testNumberBetween() {

    }

}