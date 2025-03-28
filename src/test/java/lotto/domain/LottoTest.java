package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void 로또번호는_중복되지않는다() {
        assertThatThrownBy(() -> {
            List<LottoNum> numbers = List.of(
                new LottoNum(1),
                new LottoNum(2),
                new LottoNum(3),
                new LottoNum(4),
                new LottoNum(5),
                new LottoNum(5) // 중복
            );
            new Lotto(numbers);
        }).hasMessage("로또 번호는 중복될 수 없습니다.");
    }

    @Test
    void 로또번호는_항상_6개이다() {
        assertThatThrownBy(() -> {
            List<LottoNum> numbers = List.of(
                new LottoNum(1),
                new LottoNum(2),
                new LottoNum(3),
                new LottoNum(4),
                new LottoNum(5) // 5개
            );
            new Lotto(numbers);
        }).hasMessage("로또 번호는 6개여야 합니다.");
    }


    @Test
    void 로또번호_맞추기() {
        Lotto lotto = new Lotto(List.of(
            new LottoNum(1),
            new LottoNum(2),
            new LottoNum(3),
            new LottoNum(4),
            new LottoNum(5),
            new LottoNum(6)
        ));

        Lotto other = new Lotto(List.of(
            new LottoNum(1),
            new LottoNum(2),
            new LottoNum(3),
            new LottoNum(7),
            new LottoNum(8),
            new LottoNum(9)
        ));
        assertThat(lotto.matchCount(other)).isEqualTo(3);
    }


}
