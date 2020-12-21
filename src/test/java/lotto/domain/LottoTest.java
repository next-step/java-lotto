package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoTest {
    @Test
    @DisplayName("6개의 1~45 숫자가 정상적으로 저장되는지 테스트")
    void getNumberTest() {
        Lotto lotto = new Lotto(8, 21, 23, 41, 42, 43);
        Lotto otherLotto = new Lotto(8, 21, 23, 41, 42, 43);
        assertThat(lotto.getNumbers()).isEqualTo(otherLotto.getNumbers());
    }

    @Test
    @DisplayName("1~45 숫자가 외의 숫자가 입력시 Exception 발생하는지 테스트")
    void invalidNumberTest() {
        assertThatThrownBy(() -> new Lotto(0, 1, 2, 3, 4, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또와 뽑은 로또간 비교를 한다.")
    @ParameterizedTest
    @MethodSource("generateArgumentsCompareMatchNumberCount")
    void compareMatchNumberCount(Set<LottoNumber> lottoLottoNumbers, Set<LottoNumber> winnerLottoNumbers, int matchCount) {
        Lotto lotto = new Lotto(lottoLottoNumbers);
        Lotto winnerLotto = new Lotto(winnerLottoNumbers);
        assertThat(lotto.matchNumberCount(winnerLotto)).isEqualTo(matchCount);
    }

    private static Stream<Arguments> generateArgumentsCompareMatchNumberCount() {
        List<Arguments> listOfArguments = new ArrayList<>();
        Set<LottoNumber> lottoNumbers = Stream.of(8, 21, 23, 41, 42, 43)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        listOfArguments.add(Arguments.of(
                lottoNumbers, Stream.of(8, 21, 23, 41, 42, 43).map(LottoNumber::new).collect(Collectors.toSet()), 6
        ));
        listOfArguments.add(Arguments.of(
                lottoNumbers, Stream.of(8, 21, 23, 41, 42, 44).map(LottoNumber::new).collect(Collectors.toSet()), 5
        ));
        listOfArguments.add(Arguments.of(
                lottoNumbers, Stream.of(8, 21, 23, 40, 42, 44).map(LottoNumber::new).collect(Collectors.toSet()), 4
        ));
        listOfArguments.add(Arguments.of(
                lottoNumbers, Stream.of(1, 21, 23, 40, 42, 44).map(LottoNumber::new).collect(Collectors.toSet()), 3
        ));
        listOfArguments.add(Arguments.of(
                lottoNumbers, Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toSet()), 0
        ));
        return listOfArguments.stream();
    }

    @DisplayName("보너스 번호와 뽑은 로또간 비교를 한다.")
    @ParameterizedTest
    @MethodSource("generateArgumentsCompareMatchBonus")
    void compareMatchBonus(Lotto lotto, int bonusNumber, boolean matchBonus) {
        LottoNumber bonus = new LottoNumber(bonusNumber);
        assertThat(lotto.matchBonus(bonus)).isEqualTo(matchBonus);
    }

    private static Stream<Arguments> generateArgumentsCompareMatchBonus() {
        Lotto lotto = new Lotto(8, 21, 23, 41, 42, 43);

        List<Arguments> listOfArguments = new ArrayList<>();
        listOfArguments.add(Arguments.of(lotto, 8, true));
        listOfArguments.add(Arguments.of(lotto, 43, true));
        listOfArguments.add(Arguments.of(lotto, 1, false));

        return listOfArguments.stream();
    }

}