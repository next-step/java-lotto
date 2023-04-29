package lotto.domain;

import lotto.domain.strategy.FixedRandomStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.domain.MatchNumbersCount.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {
  private LottoGame lottoGame;
  private LottoNumbers winningNumbers;
  private LottoNumber bonusNumber;

  @BeforeEach
  void setUp() {
    lottoGame = new LottoGame(new Money(14000), new FixedRandomStrategy());
    winningNumbers = new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6)
                                            .map(LottoNumber::from)
                                            .collect(Collectors.toList()));
    bonusNumber = LottoNumber.from(7);
  }

  @Test
  void 보너스번호가_당첨번호와_중복되면_IllegalArgumentException이_발생한다() {
    LottoNumber duplicateNumber = LottoNumber.from(6);
    assertThatThrownBy(() -> lottoGame.getStatistics(winningNumbers, duplicateNumber))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 번호는 중복될 수 없습니다.");
  }

  @Test
  void 통계를_반환한다() {
    // given
    Map<MatchNumbersCount, Integer> countByMatchNumbersCount = new HashMap<>();
    countByMatchNumbersCount.put(MATCH_0, 8);
    countByMatchNumbersCount.put(MATCH_1, 1);
    countByMatchNumbersCount.put(MATCH_2, 1);
    countByMatchNumbersCount.put(MATCH_3, 1);
    countByMatchNumbersCount.put(MATCH_4, 1);
    countByMatchNumbersCount.put(MATCH_5, 0);
    countByMatchNumbersCount.put(MATCH_5_AND_BONUS, 1);
    countByMatchNumbersCount.put(MATCH_6, 1);
    LottoStatistics lottoStatistics = new LottoStatistics(countByMatchNumbersCount);

    // when
    // then
    assertThat(lottoGame.getStatistics(winningNumbers, bonusNumber))
        .isEqualTo(lottoStatistics);
  }
}