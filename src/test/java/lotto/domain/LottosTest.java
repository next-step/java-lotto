package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    @DisplayName("금액에 해당하는 수만큼 로또를 가진 일급 컬렉션 Lottos를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "6000, 6", "14000, 14"})
    void create(int money, int expectedCount) {
        assertThat(new Lottos(money).getSize()).isEqualTo(expectedCount);
    }

    @DisplayName("구입 금액 1000원 미만일 경우 IllegalArgumentException을 throw한다.")
    @Test
    public void exception() {
        assertThatThrownBy(() -> new Lottos(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또를 한 장 이상 구매하세요.");
    }

    @DisplayName("countMatch 함수는 당첨 번호를 받아 전체 발급 로또에 대한 PrizeType 별 count를 통계한 Map을 반환한다.")
    @Test
    void countMatch() {
        int money = 1000;
        Lottos lottos = new Lottos(money);
        // 구입한 로또로 당첨번호 생성
        List<Integer> winningNumbers = lottos.getLottos().get(0)
                .getNumbers().stream()
                .map(LottoNumber::number)
                .collect(Collectors.toList());
        int meaninglessBonusNumber = 1; // 우연의 일치로 당첨 번호와 보너스 번호가 겹치면 테스트 실패 가능
        WinningLotto winningLotto = new WinningLotto(winningNumbers, meaninglessBonusNumber);

        PrizeStatistic prizeStat = lottos.countMatch(winningLotto);
        assertThat(prizeStat).isInstanceOf(PrizeStatistic.class);
        assertThat(prizeStat.getOrDefault(PrizeType.FIRST)).isEqualTo(1);
    }
}
