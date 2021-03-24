package step2.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.Money;
import step2.domain.exception.CustomException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        this.lottoMachine = new LottoMachine();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "6000:6",
            "5500:5",
            "14200:14"}, delimiter = ':')
    @DisplayName("살 수 있는 로또의 개수를 구할 수 있다")
    void calculatesLottoCapacity(int wanted, int expected) {
        int capacity = lottoMachine.normalLottoCapacity(new Money(wanted));
        assertThat(capacity).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "6:6",
            "5:5",
            "14:14"}, delimiter = ':')
    @DisplayName("원하는 수의 자동 로또를 살 수 있다")
    void canBuyValidLottoSize(int wanted, int expected) {
        LottoList lottoList = lottoMachine.buyAutoLotto(wanted);
        assertThat(lottoList.getLottos().size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1000:6",
            "500:5",
            "2400:14"}, delimiter = ':')
    @DisplayName("원하는 수의 로또를 살 수 있다")
    void throwsExceptionWhenBuyMoreThanAvailable(int amount, int count) {
        assertThrows(CustomException.class, ()-> lottoMachine.verifyCapacity(new Money(amount), count));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1000 :1 :0",
            "1600 :1 :600",
            "5100 :0 :5100",
            "51000 :13:38000",
            "140010:1 :139010"}, delimiter = ':')
    @DisplayName("로또기계가 잔돈을 거슬러 줄 수 있다")
    void canCalculateChange(int wanted, int count, int expected) {
        int change = lottoMachine.change(new Money(wanted), count);
        assertThat(change).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6 :1,2,3,4,5,6",
            "6,5,4,3,2,1 :1,2,3,4,5,6"}, delimiter = ':')
    @DisplayName("문자열을 통해 수동 로또 구매가 가능하다")
    void canBuyLottoManually(String manualLotto, String expected) {
        List<String> stringLottoList = new ArrayList<>();
        stringLottoList.add(manualLotto);

        List<LottoBall> lottoBalls = Arrays.stream(expected.split(","))
                .map(Integer::parseInt)
                .map(LottoBall::new)
                .collect(Collectors.toList());

        LottoList lottoList = lottoMachine.buyManualLotto(stringLottoList);
        List<LottoBall> generatedLottoBalls = lottoList.getLottos().get(0).getBalls();
        for(int idx = 0;idx<generatedLottoBalls.size();idx++){
            assertThat(generatedLottoBalls.get(idx)).isEqualTo(lottoBalls.get(idx));
        }

    }

}
