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
        LottoMachine lottoMachine = new LottoMachine();

        int money = 13500;

        Lottos lotto = lottoMachine.createLotto(money);

        assertThat(lotto.lottoCount()).isEqualTo(13);
    }

    @DisplayName("만들 로또 갯수를 생성")
    @Test
    void getLottoCount() {
        LottoMachine lottoMachine = new LottoMachine();

        int money = 12000;

        int lottoCount = lottoMachine.getLottoCount(money);

        assertThat(lottoCount).isEqualTo(12);
    }

    @DisplayName("지불한 가격이 1000원 단위가 아닐 경우 예외 발생")
    @Test
    void moneyVaild() {
        LottoMachine lottoMachine = new LottoMachine();

        int money = 12002;

        assertThatThrownBy(() -> {
            lottoMachine.getLottoCount(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("1000원 단위로 돈을 지불해주세요");
    }

    @DisplayName("로또 매칭 결과 테스트")
    @Test
    void getRank() {
        List<LottoNumber> winNumber = createLotto(1, 2, 3, 4, 5, 6).toNumberList();
        LottoMachine lottoMachine = new LottoMachine(createLottos());
        List<Rank> ranks = lottoMachine.getRankOfLottos(winNumber);

        assertThat(ranks).containsExactly(Rank.FIRST, Rank.SECOND, Rank.MISS, Rank.FOURTH);
    }

    @DisplayName("String 문자열을 로또 번호 리스트로 변환 테스트")
    @Test
    void toLottoNumberList() {
        LottoMachine lottoMachine = new LottoMachine();
        String winNumber = "1,2,3,4,5,6";
        List<LottoNumber> lottoNumbers = lottoMachine.toLottoNumberList(winNumber);

        assertThat(lottoNumbers).containsExactly(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    }

    @DisplayName("당첨번호가 6개가 아닐 경우")
    @Test
    void valid_당첨번호길이검증() {
        LottoMachine lottoMachine = new LottoMachine();
        String winNumber = "1,2,3,4,5";

        assertThatThrownBy(() -> {
            lottoMachine.toLottoNumberList(winNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("당첨번호가 6개가 아닙니다.");
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