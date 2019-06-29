package step2.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.dto.LottoDTO;
import step2.dto.LottosDTO;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class UserPickLottosFactoryTest {
    @Test
    @DisplayName("유저가 선택한 로또로 생성")
    void create_user_pick() {
        UserPickLottosFactory factory = new UserPickLottosFactory();
        Lottos lottos = factory.apply(new LottosDTO(List.of(new LottoDTO(List.of(1, 2, 3, 4, 5, 6)))));
        assertAll(
            () -> assertThat(lottos.size()).isEqualTo(1),
            () -> assertThat(lottos.getTotalPrice()).isEqualTo(new Money(1_000L)),
            () -> assertThat(lottos.getLottos()
                                   .get(0)
                                   .matchLottoNumber(new WinningLotto(Lotto.create(List.of(1, 2, 3, 4, 5, 6))))).isEqualTo(LottoRank.FIRST)
        );
    }
}
