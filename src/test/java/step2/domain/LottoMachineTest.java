package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    @DisplayName("받은 돈 만큼 로또를 생성한다.")
    @Test
    void lottoCount() {
        //given
        int money = 13000;
        LottoMachine lottoMachine = new LottoMachine(money);

        //when
        Lottos lotto = lottoMachine.createLotto();

        //then
        assertThat(lotto.lottoCount()).isEqualTo(13);
    }

    @DisplayName("로또 매칭 결과 테스트")
    @Test
    void getRank() {
        //given
        List<LottoNumber> winNumber = createLotto(1, 2, 3, 4, 5, 6).toNumberList();
        LottoMachine lottoMachine = new LottoMachine(createLottos());

        //when
        List<Integer> ranks = lottoMachine.getRankOfLottos(winNumber);

        //then
        assertThat(ranks).containsExactly(6, 5, 0, 4);
    }

    @DisplayName("String 문자열을 로또 번호 리스트로 변환 테스트")
    @Test
    void toLottoNumberList() {
        //given
        LottoMachine lottoMachine = new LottoMachine();
        String winNumber = "1,2,3,4,5,6";

        //when
        List<LottoNumber> lottoNumbers = lottoMachine.toLottoNumberList(winNumber);

        //then
        assertThat(lottoNumbers).containsExactly(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    }

    @DisplayName("당첨번호가 6개가 아닐 경우")
    @Test
    void valid_당첨번호길이검증() {
        //given
        LottoMachine lottoMachine = new LottoMachine();
        String winNumber = "1,2,3,4,5";

        //then
        assertThatThrownBy(() -> {
            lottoMachine.toLottoNumberList(winNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("당첨번호가 6개가 아닙니다.");
    }

    @DisplayName("보너스볼과 매칭한 결과들을 반환한다.")
    @Test
    void getMatchOfBonus() {
        LottoMachine lottoMachine = new LottoMachine(createLottos());
        List<Boolean> resultMatchList = lottoMachine.getMatchOfBonus(new LottoNumber(6));

        assertThat(resultMatchList.get(0)).isTrue();
        assertThat(resultMatchList.get(1)).isFalse();
    }

    Lotto createLotto(int one, int two, int three, int four, int five, int six) {
        return new Lotto(List.of(new LottoNumber(one), new LottoNumber(two), new LottoNumber(three), new LottoNumber(four), new LottoNumber(five), new LottoNumber(six)));
    }

    Lottos createLottos() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))));
        lottoList.add(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(7))));
        lottoList.add(new Lotto(List.of(new LottoNumber(7), new LottoNumber(8), new LottoNumber(9), new LottoNumber(10), new LottoNumber(11), new LottoNumber(12))));
        lottoList.add(new Lotto(List.of(new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(11), new LottoNumber(24))));
        return new Lottos(lottoList);
    }
}