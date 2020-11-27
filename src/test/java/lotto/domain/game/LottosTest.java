package lotto.domain.game;

import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created By mand2 on 2020-11-19.
 */
class LottosTest {

    @org.junit.jupiter.api.Test
    @DisplayName("랜덤X: 게임 횟수에 따른 로또 리스트 생성")
    void generate_lotto_manually() {
        // shuffle을 그냥 세팅해버렷
        // given
        List<LottoNumber> t = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());

        LottoNumberSet lottoNumberSet = LottoNumberSet.of(t);

        // when
        Lotto lotto = Lotto.of(lottoNumberSet);
        Lottos lottos = Lottos.of(Arrays.asList(lotto, lotto, lotto));

        // then
        for (Lotto l : lottos.list()) {
            assertThat(l.number()).containsExactlyElementsOf(t);
        }
    }

    @ParameterizedTest
    @DisplayName("랜덤O: 게임 횟수에 따른 로또 리스트 생성")
    @ValueSource(ints = {1,2,3,4,5})
    void generate_lotto_randomly(int inputRound) {

        // given
        Lottos lottos = LottoGenerator.generate(inputRound);

        // when
        int size = lottos.list().size();

        // then
        assertThat(size).isEqualTo(inputRound);

    }

    @org.junit.jupiter.api.Test
    @DisplayName("자동으로 생성된 로또 게임 두개의 로또번호는 같지않다")
    void is_automated_lotto_number_same() {
        // given
        Lottos automatedLotto1 = LottoGenerator.generate(1);;
        Lottos automatedLotto2 = LottoGenerator.generate(1);;

        // when
        List<Lotto> lottos1 = automatedLotto1.list();
        List<Lotto> lottos2 = automatedLotto2.list();

        // then
        assertThat(false).isEqualTo(lottos1.equals(lottos2));
    }


}
