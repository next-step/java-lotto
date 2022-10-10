package Lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoNumberCreateMachineTest {

    static final int WANTED_LOTTO_COUNT = 6;
    private static final int LOTTO_NUMBER_ONE = 1;
    private static final int LOTTO_NUMBER_TWO = 2;
    private static final int LOTTO_NUMBER_THREE = 3;
    private static final int LOTTO_NUMBER_FOUR = 4;
    private static final int LOTTO_NUMBER_FIVE = 5;
    private static final int LOTTO_NUMBER_SIX = 6;

    @Test
    @DisplayName("로또가 천원일 때 가격만큼 사는지 확인")
    public void buyLottoTest() {
        LottoNumberCreateMachine lottoNumberCreateMachine = new LottoNumberCreateMachine();
        Lottos lottos = lottoNumberCreateMachine.createLottos(WANTED_LOTTO_COUNT);
        int lottoCount = lottos.getLottos().size();
        assertThat(lottoCount).isEqualTo(WANTED_LOTTO_COUNT);
    }

    @Test
    @DisplayName("당첨번호를 생성할 때 잘 생성되어지는지 확인")
    public void constructorSuccessTest() {
        LottoNumberCreateMachine lottoNumberCreateMachine = new LottoNumberCreateMachine();
        List<String> numbers = List.of(
                "1", "2", "3", "4", "5", "6"
        );
        Lotto wantedLuckyNumbers = new Lotto(
                List.of(
                        new LottoNumber(LOTTO_NUMBER_ONE),
                        new LottoNumber(LOTTO_NUMBER_TWO),
                        new LottoNumber(LOTTO_NUMBER_THREE),
                        new LottoNumber(LOTTO_NUMBER_FOUR),
                        new LottoNumber(LOTTO_NUMBER_FIVE),
                        new LottoNumber(LOTTO_NUMBER_SIX)
                )
        );
        assertThat(wantedLuckyNumbers).isEqualTo(lottoNumberCreateMachine.getLuckyNumbers(numbers));
    }

}