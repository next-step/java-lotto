package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottosTest {

  static Stream<Arguments> multiComparingSource() {
    return Stream.of(
        arguments(
            Lists.list(
                new Lotto(new String[]{"1", "2", "3", "4", "5", "6"}),
                new Lotto(new String[]{"2", "5", "6", "8", "9", "20"})
            ),
            new Lotto(new String[]{"2", "5", "7", "8", "9", "13"}),
            LottoNumber.valueOf("14"),
            Lists.list(new LottoMatch(2, false), new LottoMatch(4, false))),
        arguments(
            Lists.list(
                new Lotto(new String[]{"45", "44", "43", "42", "41", "40"}),
                new Lotto(new String[]{"1", "2", "3", "4", "5", "6"})
            ),
            new Lotto(new String[]{"1", "2", "3", "4", "5", "6"}),
            LottoNumber.valueOf("7"),
            Lists.list(new LottoMatch(0, false), new LottoMatch(6, false)))
    );
  }

  @Test
  @DisplayName("크기를 입력받아, 로또 목록을 만든다.")
  void create() {
    // given
    long size = 14;

    // when
    Lottos lottos = new Lottos(size);

    // then
    assertThat(lottos.getLottos()).isNotNull();
  }

  @ParameterizedTest
  @DisplayName("여러개의 로또 번호를 받아서 당첨번호와 비교해 일치한 개수 목록을 반환한다.")
  @MethodSource("multiComparingSource")
  void compare(List<Lotto> lottoList, Lotto winningLotto, LottoNumber bonusNumber, List<LottoMatch> expected) {
    // given
    Lottos lottos = new Lottos(lottoList);

    // when
    List<LottoMatch> lottoMatches = lottos.compare(new WinningLotto(winningLotto, bonusNumber));

    // then
    assertThat(lottoMatches).isEqualTo(expected);
  }

  @Test
  @DisplayName("로또를 추가할 수 있다.")
  void addLotto() {
    // given
    Lottos lottos = new Lottos();
    Lotto lotto = new Lotto();

    // when
    lottos.addLotto(lotto);

    // then
    assertThat(lottos.getLottos()).containsAnyOf(lotto);
  }

  @Test
  @DisplayName("로또목록을 추가할 수 있다.")
  void addLottoList() {
    // given
    Lottos lottos = new Lottos();
    List<Lotto> lottoList = Lists.list(new Lotto(), new Lotto(), new Lotto());

    // when
    lottos.addLottoList(lottoList);

    // then
    assertThat(lottos.getLottos()).containsAll(lottoList);
  }
}
