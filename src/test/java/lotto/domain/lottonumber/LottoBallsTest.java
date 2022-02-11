package lotto.domain.lottonumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBallsTest {

    @DisplayName("로또 번호는 1부터 45까지를 가진다.")
    @Test
    void When_로또_공_생성_Then_범위는_1부터_45() {
        // then
        for (int i = 1; i <= 45; i++) {
            assertThat(LottoBalls.from(i)).isNotNull();
        }
    }

    @DisplayName("랜덤 로또 생성은 생성할 때마다 번호가 다르다")
    @Test
    void When_로또_번호_리스트_섞기_Then_섞기_전과_요소의_순서가_다름() {
        // then
        assertThat(LottoBalls.getRandomLottoNumber()).isNotEqualTo(LottoBalls.getRandomLottoNumber());
    }


    @DisplayName("임의의 6개의 로또번호가 생성된다.")
    @Test
    void When_로또번호_생성_Then_로또볼_에서_6개를_뽑는다() {
        // when
        final Set<LottoNumber> lottoNumbers = LottoBalls.getRandomLottoNumber();

        // then
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @DisplayName("생성된 로또 번호는 오름차순으로 정렬 된다.")
    @Test
    void When_로또번호_생성_Then_오른_차순_정렬됨() {
        // when
        final List<Integer> lottoNumbers = LottoBalls.getRandomLottoNumber().stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList());

        // then
        int prev = 0;
        for (int number : lottoNumbers) {
            assertTrue(number > prev);
            prev = number;
        }
    }

    @DisplayName("넘겨준 값에 해당하는 로또 번호 객체를 반환한다.")
    @Test
    void When_정상번호_Then_값에_해당하는_로또_번호_객체_반환() {
        assertThat(LottoBalls.from(7).getValue()).isEqualTo(7);
    }

    @DisplayName("넘겨준 리스트 값에 해당하는 로또 번호 객체 리스트를 반환한다.")
    @Test
    void When_정상번호_리스트_Then_값들에_해당하는_로또_번호_객체_리스트_반환() {
        final List<Integer> returnValues = LottoBalls.of(Arrays.asList(3, 4, 5, 6, 7, 8)).stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList());

        // then
        assertThat(returnValues).isEqualTo(Arrays.asList(3, 4, 5, 6, 7, 8));
    }

    @DisplayName("로또 번호 하나를 가져올 때 1 ~ 45 범위의 숫자가 아니면 예외가 발생한다.")
    @Test
    void When_로또_숫자_범위를_벗어난_한_개의_수_Then_예외_발생() {
        // then
        assertThrows(IllegalArgumentException.class, () -> LottoBalls.from(46));
    }

    @DisplayName("로또 번호들을 가져올 때 1 ~ 45 범위의 숫자가 아니면 예외가 발생한다.")
    @Test
    void When_로또_숫자_범위를_벗어난_여러개의_수_Then_예외_발생() {
        // then
        assertThrows(IllegalArgumentException.class,
                () -> LottoBalls.of(Arrays.asList(1, 2, 3, 4, 5, 46)));
    }
}
