package lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    //입력받은 구입금액에 해당하는 로또 구매 갯수 반환 (1장, 1000원)
    //길이 6인 로또 번호 리스트 구매 갯수 만큼 생성
    //로또번호 정렬 확인
    //입력받은 당첨 번호가 로또 번호 리스트에 있는지 확인
    //로또 하나당 일치하는 갯수 넘겨받아 3~6개 일치 할 경우 총 당첨금 체크
    //구입금액/당첨금 으로 수익률 체크

    LottoGame lottoGame;

    @Before
    public void setUp() throws Exception {
        lottoGame = new LottoGame();
    }

    @Test
    public void 구입금액_로또구매갯수반환() {
        int a = lottoGame.calcLottoCount(14000);
        assertThat(a).isEqualTo(14);
    }

    @Test
    public void 로또번호의길이가6인_로또번호리스트_구매갯수만큼생성() {
        List<List<Integer>> lottos = lottoGame.makeLottoList(lottoGame.lottoNumbersSetting(), lottoGame.calcLottoCount(14000));
        assertThat(lottos.size()).isEqualTo(lottoGame.calcLottoCount(14000));
        assertThat(lottos.get(0).size()).isEqualTo(6);
    }

    @Test
    public void 로또번호정렬확인() {
        List<Integer> lotto = new ArrayList<>();
        lotto.add(3);
        lotto.add(2);
        lotto.add(1);
        assertThat(lotto.get(0)).isEqualTo(3);
        lottoGame.sortLottoNumbers(lotto);
        assertThat(lotto.get(0)).isEqualTo(1);
    }
    @Test
    public void 당첨번호포함_갯수확인() {
        List<Integer> lottos = new ArrayList<>();
        lottos.add(3);
        lottos.add(13);
        lottos.add(15);
        lottos.add(21);
        lottos.add(28);
        lottos.add(41);
        List<Integer> pickLottoNumber = new ArrayList<>();
        pickLottoNumber.add(3);
        pickLottoNumber.add(13);
        pickLottoNumber.add(17);
        pickLottoNumber.add(18);
        pickLottoNumber.add(33);
        pickLottoNumber.add(34);

        int sum = 0;
        for(int number : pickLottoNumber) {
            sum += lottoGame.containsPerOneLotto(lottos, number);
        }
        assertThat(sum).isEqualTo(2);
    }

    @Test
    public void 촏당첨금체크() {
        int[] winPrice = {5000, 50000, 1500000, 2000000000};
        int[] winResult = {1, 0, 0, 0};
        assertThat(lottoGame.totalPrice(winResult, winPrice)).isEqualTo(5000);
    }
}