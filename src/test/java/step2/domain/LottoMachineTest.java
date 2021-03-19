package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.util.StringParser;

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
        LottoMachine lottoMachine = new LottoMachine();

        //when
        Lottos lotto = lottoMachine.createLotto(money, List.of("1, 2, 3, 4, 5, 6"));

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
        List<LottoNumber> lottoNumbers = StringParser.toLottoNumberList(winNumber);

        //then
        assertThat(lottoNumbers).containsExactly(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
    }

    @DisplayName("당첨번호가 6개가 아닐 경우")
    @Test
    void valid_당첨번호길이검증() {
        //given
        LottoMachine lottoMachine = new LottoMachine();
        List<LottoNumber> winNumber = List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5));

        //then
        assertThatThrownBy(() -> {
            lottoMachine.statistics(winNumber, LottoNumber.of(7));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("당첨번호가 6개가 아닙니다.");
    }

    @DisplayName("보너스볼과 매칭한 결과들을 반환한다.")
    @Test
    void getMatchOfBonus() {
        LottoMachine lottoMachine = new LottoMachine(createLottos());
        List<Boolean> resultMatchList = lottoMachine.getMatchOfBonus(LottoNumber.of(6));

        assertThat(resultMatchList.get(0)).isTrue();
        assertThat(resultMatchList.get(1)).isFalse();
    }

    Lotto createLotto(int one, int two, int three, int four, int five, int six) {
        return new Lotto(List.of(LottoNumber.of(one), LottoNumber.of(two), LottoNumber.of(three), LottoNumber.of(four), LottoNumber.of(five), LottoNumber.of(six)));
    }

    Lottos createLottos() {
        List<String> lottoList = new ArrayList<>();
        lottoList.add("1,2,3,4,5,6");
        lottoList.add("1,2,3,4,5,7");
        lottoList.add("7,8,9,10,11,12");
        lottoList.add("2,3,4,5,11,24");
        return new Lottos(lottoList);
    }
    
}