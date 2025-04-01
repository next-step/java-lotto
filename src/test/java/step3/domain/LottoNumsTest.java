package step3.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoNumsTest {

    @Test
    void 로또숫자집합은_로또숫자들을_가짐() {
        LottoNums lottoNums = new LottoNums(List.of(
                new LottoNum(1),
                new LottoNum(2),
                new LottoNum(3),
                new LottoNum(4),
                new LottoNum(5),
                new LottoNum(6)
        ));
        assertThat(lottoNums.getLottoNums()).containsExactlyInAnyOrder(
                new LottoNum(1),
                new LottoNum(2),
                new LottoNum(3),
                new LottoNum(4),
                new LottoNum(5),
                new LottoNum(6)
        );
    }

    @Test
    void 중복_안됨() {
        assertThatThrownBy(() -> new LottoNums(List.of(
                new LottoNum(1),
                new LottoNum(1),
                new LottoNum(3),
                new LottoNum(4),
                new LottoNum(5),
                new LottoNum(6)
        )))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("로또 숫자는 중복될 수 없습니다.");
    }

    @Test
    void 갯수는_여섯개() {
        assertThatThrownBy(() -> new LottoNums(List.of(
                new LottoNum(1),
                new LottoNum(1),
                new LottoNum(3),
                new LottoNum(4),
                new LottoNum(5),
                new LottoNum(6)
        )))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("로또 숫자는 6개여야합니다.");
    }

    @Test
    void 숫자가_포함되는지_확인하는_메서드() {
        LottoNums lottoNums = new LottoNums(List.of(
                new LottoNum(1),
                new LottoNum(2),
                new LottoNum(3),
                new LottoNum(4),
                new LottoNum(5),
                new LottoNum(6)
        ));
        assertThat(lottoNums.contains(new LottoNum(1))).isTrue();
        assertThat(lottoNums.contains(new LottoNum(7))).isFalse();
    }
}
