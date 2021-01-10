package lotto.domain;

import lotto.util.NumberUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setup() {
        lotto = new Lotto();
    }

    @Test
    void createLotto() {
        Lotto lotto = this.lotto.createLotto();
        assertThat(lotto.numberOfLottoCount()).isEqualTo( 6);
    }

    @Test
    void toStringLotto() {
        Set<LottoNumber> lottoNumberSet = generateCustomNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumberSet);
        HashSet<LottoNumber> lottoNumber = lotto.showLottoNumber();
        boolean contains = lottoNumber.contains(new LottoNumber(1));
        assertAll(
            ()-> assertThat(lottoNumber.contains( new LottoNumber(1))).isTrue(),
            ()-> assertThat(lottoNumber.contains( new LottoNumber(2))).isTrue(),
            ()-> assertThat(lottoNumber.contains( new LottoNumber(3))).isTrue(),
            ()-> assertThat(lottoNumber.contains( new LottoNumber(4))).isTrue(),
            ()-> assertThat(lottoNumber.contains( new LottoNumber(5))).isTrue(),
            ()-> assertThat(lottoNumber.contains( new LottoNumber(6))).isTrue()
        );


    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,8,9,6", "1,2,3,8,9,11"})
    void checkLastWinningNumber(String lastWinnerNumber){
        Set<LottoNumber> lottoNumberSet = generateCustomNumber(Arrays.asList(1,2,3,8,9,10));
        Lotto lotto = new Lotto(lottoNumberSet);
        lotto.selectedNumber(lottoNumberSet);
        int matchCount = lotto.checkLastWinningNumberSet(lastWinnerNumber);
        assertThat(matchCount).isEqualTo(5);
    }

    @Test
    void checkBonusNumber_True( ) {
        Set<LottoNumber> lottoNumberSet = generateCustomNumber(Arrays.asList(1,2,3,4,5,10));
        BonusNumber bonusNumber = new BonusNumber(10);
        Lotto lotto = new Lotto(lottoNumberSet);
        boolean bonusNumberIsExist = lotto.checkBonusNumber(bonusNumber);
        assertThat(bonusNumberIsExist).isEqualTo(true);
    }

    @Test
    void checkBonusNumber_False( ) {
        Set<LottoNumber> lottoNumberSet = generateCustomNumber(Arrays.asList(1,2,3,4,5,10));
        BonusNumber bonusNumber = new BonusNumber(22);
        Lotto lotto = new Lotto(lottoNumberSet);
        boolean bonusNumberIsExist = lotto.checkBonusNumber(bonusNumber);
        assertThat(bonusNumberIsExist).isEqualTo(false);
    }

    @Test
    void generateRandomNumberSet() {
        Set<LottoNumber> lottoSet = lotto.generateRandomNumbersSet();
        assertThat(lottoSet.size()).isEqualTo(6);
    }

    private Set<LottoNumber> generateCustomNumber(List<Integer> customLottoNumbers) {
        Set<LottoNumber> lottoNumberSet = customLottoNumbers.stream()
                .map(LottoNumber::new).collect(Collectors.toSet());
        return lottoNumberSet;
    }

    @Test
    void compareContain(){
        Set<LottoNumber> set = new HashSet<>();
        set.add(new LottoNumber(5));
        boolean contains = set.contains(new BonusNumber(5).getLottoNumber());
        assertThat(contains).isTrue();
    }

    @Test
    void equalsLotto_Test() {
        String numbers = "1,2,3,4,5,6";
        Set<LottoNumber> lottoNumberSet = NumberUtil.convertStringLottoNumbers(numbers);
        Lotto lotto = new Lotto(lottoNumberSet);
        Lotto lotto1 = new Lotto(lottoNumberSet);
        assertThat(lotto).isEqualTo(lotto1);
    }
}