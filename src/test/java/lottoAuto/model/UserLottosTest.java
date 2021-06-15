package lottoAuto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserLottosTest {

    private List<Lotto> lottos = new ArrayList<>();
    private List<Integer> lotto = new ArrayList<>();
    private int bonus;

    @BeforeEach
    public void init() {
        List<Integer> userLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userLotto2 = Arrays.asList(7, 8, 9, 10, 11, 12);

        lotto = Arrays.asList(1,2,3,4,5,12);
        bonus = 6;

        this.lottos.add(new Lotto(userLotto));
        this.lottos.add(new Lotto(userLotto2));
    }

    @Test
    public void getStatistic(){
        UserLottos userLottos = new UserLottos(this.lottos);
        Lotto winningLotto = new Lotto(this.lotto);

        LottoResults lottoResults = getStatistic(userLottos.getUserLottoNumbers(),winningLotto);
        assertThat(lottoResults.getLottoResult().get(0).getCount()).isEqualTo(5);
        assertThat(lottoResults.getLottoResult().get(0).getBonus()).isEqualTo(true);
        assertThat(lottoResults.getLottoResult().get(1).getCount()).isEqualTo(1);
        assertThat(lottoResults.getLottoResult().get(1).getBonus()).isEqualTo(false);
    }

    public LottoResults getStatistic(List<Lotto> userLottos, Lotto winningLotto) {

        LottoResults lottoResults = new LottoResults();

        for (Lotto userLotto : userLottos) {

            LottoResult lottoResult = new LottoResult(getCount(userLotto.getLottoNumbers(), winningLotto.getLottoNumbers()),hasBonus(userLotto.getLottoNumbers(),bonus));
            lottoResults.add(lottoResult);
        }
        return lottoResults;
    }

    private int getCount(List<Integer> userLottoNumbers, List<Integer> winningLottoNumbers) {
        int count = 0;
        for (int j = 0; j < winningLottoNumbers.size(); j++) {
            if (userLottoNumbers.contains(winningLottoNumbers.get(j))) {
                count++;
            }
        }
        return count;
    }

    private Boolean hasBonus(List<Integer> userLottoNumbers, int bonus){

        return userLottoNumbers.contains(bonus);
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