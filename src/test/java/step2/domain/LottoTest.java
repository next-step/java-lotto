package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.dto.LottoWinningResult;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("로또 당첨 번호를 전달하면 일치하는 개수가 몇 개 있는지 알 수 있다.")
    @Test
    void getWinningInfo() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from(numbers);

        LottoWinningRules lottoWinningRules = new LottoWinningRules();

        LottoNumbers lottoNumbers1 = createLottoNumbersFrom(30, 20, 25, 1, 2, 3); //3개일치
        LottoNumbers lottoNumbers2 = createLottoNumbersFrom(1, 2, 3, 4, 5, 43); //5개 일치
        List<LottoNumbers> lottoNumbersList = createLottoNumbersListFrom(lottoNumbers1, lottoNumbers2);

        Lotto lotto = new Lotto(lottoWinningRules, lottoNumbersList, 2000);

        //when
        Map<Integer, Integer> countNumberOfMatching = lotto.countNumberOfMatching(lottoWinningNumbers);


        //then
        assertThat(countNumberOfMatching.get(3)).isEqualTo(1);
        assertThat(countNumberOfMatching.get(5)).isEqualTo(1);
        assertThat(countNumberOfMatching.keySet().size()).isEqualTo(2);
    }

    @DisplayName("로또 당첨금을 계산한다.")
    @Test
    void getPrizeMoney() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
       //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from(numbers);

        LottoWinningRules lottoWinningRules = new LottoWinningRules();

        LottoNumbers lottoNumbers1 = createLottoNumbersFrom(30, 20, 25, 1, 2, 3); //3개일치
        LottoNumbers lottoNumbers2 = createLottoNumbersFrom(1, 2, 3, 4, 5, 43); //5개 일치
        List<LottoNumbers> lottoNumbersList = createLottoNumbersListFrom(lottoNumbers1, lottoNumbers2);

        Lotto lotto = new Lotto(lottoWinningRules, lottoNumbersList, 2000);

        //when
        int prizeMoney = lotto.prizeMoney(lottoWinningNumbers);

        //then
        assertThat(prizeMoney).isEqualTo(1505000);
    }

    @DisplayName("로또 수익률을 계산한다.")
    @Test
    void earningRate() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from(numbers);

        LottoWinningRules lottoWinningRules = new LottoWinningRules();

        LottoNumbers lottoNumbers1 = createLottoNumbersFrom(30, 20, 25, 1, 2, 3); //3개일치
        LottoNumbers lottoNumbers2 = createLottoNumbersFrom(1, 2, 3, 33, 22, 43); //3개 일치
        List<LottoNumbers> lottoNumbersList = createLottoNumbersListFrom(lottoNumbers1, lottoNumbers2);

        Lotto lotto = new Lotto(lottoWinningRules, lottoNumbersList, 2000);

        //when
        int earningRate = lotto.earningRate(lottoWinningNumbers);

        //then
        assertThat(earningRate).isEqualTo(5);
    }


    private LottoNumbers createLottoNumbersFrom(Integer... numbers) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Integer> numberList = Arrays.asList(numbers);
        Constructor<LottoNumbers> declaredConstructor = LottoNumbers.class.getDeclaredConstructor(List.class);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(numberList);

    }

    private List<LottoNumbers> createLottoNumbersListFrom(LottoNumbers... lottoNumbers) {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        Collections.addAll(lottoNumbersList, lottoNumbers);
        return lottoNumbersList;
    }
}