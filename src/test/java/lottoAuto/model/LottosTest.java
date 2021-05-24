package lottoAuto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private LottoAutoService lottoAutoService = new LottoAutoService();

    private List<Lotto> userLotto = new ArrayList<>();
    private List<Integer> winningLotto = new ArrayList<>();

    @BeforeEach
    public void init() {
        List<Integer> userLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userLotto2 = Arrays.asList(7, 8, 9, 10, 11, 12);

        winningLotto = Arrays.asList(4, 5, 6, 7, 8, 9);

        this.userLotto.add(new Lotto(userLotto));
        this.userLotto.add(new Lotto(userLotto2));
    }

    @Test
    public void match() {
        LottoResultsTest lottoResultsTest = new LottoResultsTest();
//        userLotto.stream().map(lotto -> new LottoResultTest(lottoAutoService.statistic(userLotto, winningLotto)))
//                .forEach(lottoResultsTest::add);

        //map 타입 변환
//        List<String> name = new ArrayList<>();
//        List<Car> cars = name.stream().map(x -> new Car(x)).collect(Collectors.toList());

        assertThat(lottoResultsTest.getLottoResultTestList1()).isEqualTo(3);
        assertThat(lottoResultsTest.getLottoResultTestList2()).isEqualTo(3);
    }

}