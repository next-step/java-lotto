package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningLottoTest {

  @DisplayName("당첨 번호와 보너스 번호가 겹치는지 확인한다.")
  @Test
  void testWinningLottoDuplicatesBonusNumber() {
    List<LottoNumber> lottoNumbers = List.of(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
    );
    LottoNumber bonusNumber = new LottoNumber(6);

    assertThatThrownBy(() -> new WinningLotto(lottoNumbers, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
  }

  @DisplayName("내가 가진 로또에 보너스 번호가 있는지 확인한다.")
  @Test
  void testHasBonus() {
    List<LottoNumber> lottoNumbers = List.of(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
    );
    LottoNumber bonusNumber = new LottoNumber(7);
    WinningLotto winningLotto = new WinningLotto(lottoNumbers, bonusNumber);

    Lotto lottoWithoutBonusNumber = new Lotto(List.of(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
    ));
    Lotto lottoWithBonusNumber = new Lotto(List.of(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(7)
    ));

    assertThat(winningLotto.hasBonus(lottoWithoutBonusNumber)).isFalse();
    assertThat(winningLotto.hasBonus(lottoWithBonusNumber)).isTrue();
  }
}