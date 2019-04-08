package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    //생성자가 수동 입력과 자동 입력한 로또를 의도한대로 생성하는지
    public static Lotto userLotto1;
    public static Lotto userLotto2;
    public static List<Lotto> userLottos;


    @Before
    public void setUp() throws Exception {
        userLotto1 = new Lotto(Arrays.asList(1,2,3,4,5,8));
        userLotto2 = new Lotto(Arrays.asList(1,2,3,4,5,6));
        userLottos = new ArrayList<>();
        userLottos.add(userLotto1);
        userLottos.add(userLotto2);
    }

    @Test
    public void 완전자동생성() {
        LottoGame lottoGame = new LottoGame(new LottoMoney(5000));
        lottoGame.printUserLottos();
        assertThat(lottoGame.getNumberOfUserLottos()).isEqualTo(5);
    }

    @Test
    public void 수동자동생성() {
        LottoGame lottoGame = new LottoGame(new LottoMoney(5000), userLottos);
        lottoGame.printUserLottos();
        assertThat(lottoGame.getNumberOfUserLottos()).isEqualTo(5);
    }

    @Test
    public void 완전수동생성() {
        LottoGame lottoGame = new LottoGame(new LottoMoney(2000), userLottos);
        lottoGame.printUserLottos();
        assertThat(lottoGame.getNumberOfUserLottos()).isEqualTo(2);
        assertThat(lottoGame.getUserLottos()).isEqualTo(userLottos);
    }
}
