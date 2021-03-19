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
        List<LottoNumber> winNumber = List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));

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

    @DisplayName("보유하고 있는 로또와 보너스 볼과 매칭 테스트")
    @Test
    void matchOfBonus() {
        LottoNumber bonusNumber = LottoNumber.of(6);
        Lottos lottos = createLottos();

        List<Boolean> resultMatchList = lottos.matchOfBonus(bonusNumber);

        assertThat(resultMatchList.get(0)).isTrue();
        assertThat(resultMatchList.get(1)).isFalse();
    }

    @DisplayName("수동 로또를 만든다.")
    @Test
    void createManualLotto() {
        List<String> strings = List.of("1,2,3,4,5,6", "22,3,4,5,6,7");
        Lottos lottos = new Lottos(strings);

        assertThat(lottos.lottoCount()).isEqualTo(2);
        assertThat(lottos.getRankOfLotto(createWinNumber(1, 2, 3, 4, 5, 6))).isEqualTo(List.of(6, 4));
    }

    @DisplayName("수동 로또와 자동로또를 합친다.")
    @Test
    void add() {
        Lottos lottos = new Lottos(createLottos(), createLottos());

        assertThat(lottos.lottoCount()).isEqualTo(8);
        assertThat(lottos.getRankOfLotto(createWinNumber(1, 2, 3, 4, 5, 6))).isEqualTo(List.of(6, 5, 0, 4, 6, 5, 0, 4));
    }

    Lottos createLottos() {
        List<String> lottoList = new ArrayList<>();
        lottoList.add("1,2,3,4,5,6");
        lottoList.add("1,2,3,4,5,7");
        lottoList.add("7,8,9,10,11,12");
        lottoList.add("2,3,4,5,11,24");
        return new Lottos(lottoList);
    }

    Lotto createLotto(int one, int two, int three, int four, int five, int six) {
        return new Lotto(List.of(LottoNumber.of(one), LottoNumber.of(two), LottoNumber.of(three), LottoNumber.of(four), LottoNumber.of(five), LottoNumber.of(six)));
    }

    List<LottoNumber> createWinNumber(int one, int two, int three, int four, int five, int six) {
        return List.of(LottoNumber.of(one), LottoNumber.of(two), LottoNumber.of(three), LottoNumber.of(four), LottoNumber.of(five), LottoNumber.of(six));
    }
}