package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinLottoNumberTest {

    @Test
    void 보너스_번호는_당첨번호와_중복될수없다() {
        assertThatThrownBy(() -> {
            List<LottoNum> numbers = List.of(
                new LottoNum(1),
                new LottoNum(2),
                new LottoNum(3),
                new LottoNum(4),
                new LottoNum(5),
                new LottoNum(6)
            );
            Lotto lotto = new Lotto(numbers);

            new WinLottoNumber(lotto, new LottoNum(5));
        }).hasMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

}
