package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.dto.LottoDto;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private Lottos lottos;

    @BeforeEach
    void init() {
        lottos = new Lottos();
    }

    @DisplayName("로또 생성를 생성")
    @Test
    void createLotto() {
        //given
        int count = 4;

        //when
        Lottos resultLottos = lottos.createLottoList(count);

        //then
        assertThat(resultLottos.lottoCount()).isEqualTo(4);
    }

    @DisplayName("로또마다 당첨번호 매칭 후 결과 값은 로또 갯수와 같다")
    @Test
    void getRankOfLotto() {
        //given
        Lottos lottos = createLottos();
        List<LottoNumber> winNumber = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        //when
        List<Integer> rankOfLotto = lottos.getRankOfLotto(winNumber);

        //then
        assertThat(rankOfLotto.size()).isEqualTo(4);
        assertThat(rankOfLotto.get(0)).isEqualTo(6);
        assertThat(rankOfLotto.get(1)).isEqualTo(5);
    }

    @DisplayName("LottoDto 만들기 테스트")
    @Test
    void createLottoDtoList() {
        //given
        Lottos lottos = createLottos();

        //when
        List<LottoDto> lottoDtoList = lottos.getLottoDtoList();

        //then
        assertThat(lottoDtoList.size()).isEqualTo(4);
        assertThat(lottoDtoList.get(0).getLottoNumbers()).contains(1, 2, 3, 4, 5, 6);
    }

    Lottos createLottos() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))));
        lottoList.add(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(7))));
        lottoList.add(new Lotto(List.of(new LottoNumber(7), new LottoNumber(8), new LottoNumber(9), new LottoNumber(10), new LottoNumber(11), new LottoNumber(12))));
        lottoList.add(new Lotto(List.of(new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(11), new LottoNumber(24))));
        return new Lottos(lottoList);
    }

    Lotto createLotto(int one, int two, int three, int four, int five, int six) {
        return new Lotto(List.of(new LottoNumber(one), new LottoNumber(two), new LottoNumber(three), new LottoNumber(four), new LottoNumber(five), new LottoNumber(six)));
    }
}