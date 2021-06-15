package lottoAuto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserLottosTest {

    private List<UserLotto> userLottos = new ArrayList<>();
    private List<Integer> lotto = new ArrayList<>();
    private int bonus;

    @BeforeEach
    public void init() {
        List<Integer> userLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userLotto2 = Arrays.asList(7, 8, 9, 10, 11, 12);

        lotto = Arrays.asList(1,2,3,4,5,12);
        bonus = 6;

        this.userLottos.add(new UserLotto(userLotto));
        this.userLottos.add(new UserLotto(userLotto2));
    }

    @Test
    public void match() {
        LottoResultsTest lottoResultsTest = new LottoResultsTest();
//        userLotto.stream().map(lotto -> new LottoResultTest(LottoStatistic.getStatistic(userLotto, winningLotto)))
//                .forEach(lottoResultsTest::add);

        //map 타입 변환
//        List<String> name = new ArrayList<>();
//        List<Car> cars = name.stream().map(x -> new Car(x)).collect(Collectors.toList());

        assertThat(lottoResultsTest.getLottoResultTestList1()).isEqualTo(3);
        assertThat(lottoResultsTest.getLottoResultTestList2()).isEqualTo(3);
    }

}