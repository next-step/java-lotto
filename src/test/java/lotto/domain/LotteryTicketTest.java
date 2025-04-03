package lotto.domain;

import lotto.domain.product.FinalResult;
import lotto.domain.product.lotto.LotteryTicket;
import lotto.domain.product.lotto.LottoNumber;
import lotto.domain.product.lotto.LottoRank;
import lotto.view.fake.FakeInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LotteryTicketTest {

    @Test
    @DisplayName("사용자는 구매 금액을 입력할 수 있다.")
    public void lottoTest() {
        FakeInputView inputView = new FakeInputView("10000");
        Money money = new Money(inputView.parseInt());
        assertThat(money).isEqualTo(new Money(10000));
    }

    @Test
    @DisplayName("사용자는 로또를 수동으로 구매할 수 있다.")
    public void manualLottoTest() {
        FakeInputView inputView = new FakeInputView("8, 21, 23, 41, 42, 43");
        LotteryTicket lotteryTicket = new LotteryTicket(inputView.parseInput(inputView.read()));
        assertThat(lotteryTicket).isEqualTo(new LotteryTicket(inputView.parseInput(inputView.read())));
    }

    @ParameterizedTest
    @ValueSource(strings = {"8, 21, 23, 41/ 42/ 43", "WrongNumber"})
    @DisplayName("사용자가 수동 로또 번호를 잘못 입력할 경우 예외가 발생한다.")
    public void makeManualFailTest(String input) {
        FakeInputView inputView = new FakeInputView(input);
        assertThatThrownBy(() -> new LotteryTicket(inputView.parseInput(inputView.read())))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3,3,29,31,22,1"})
    @DisplayName("로또 번호는 중복으로 입력할 수 없다.")
    public void makeSameNumber(String input) {
        FakeInputView inputView = new FakeInputView(input);
        assertThatThrownBy(() -> new LotteryTicket(inputView.parseInput(inputView.read())))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3,3,29,31,22,", "43"})
    @DisplayName("로또 번호는 6자리로 이뤄져야 한다.")
    public void makeUnder6Numbers(String input) {
        FakeInputView inputView = new FakeInputView(input);
        assertThatThrownBy(() -> new LotteryTicket(inputView.parseInput(inputView.read())))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호를 자동으로 생성할 수 있다.")
    public void makeLotto() {
        LotteryTicket lotteryTicket = new LotteryTicket();
        assertThat(lotteryTicket.getLottoNumbersCount()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호의 맞춘 개수에 따라 받는 가격을 알 수 있다.")
    public void getRank() {
        LottoRank lottoRank = LottoRank.of(3, false);
        assertThat(lottoRank.getPrize()).isEqualTo(5000);
    }

    @Test
    @DisplayName("맞춘 개수에 따라 받는 총 상금을 알 수 있다.")
    public void getPrize() {
        FinalResult result = new FinalResult();
        result.put(LottoRank.of(3, false));
        result.put(LottoRank.of(4, false));
        Money totalPrize = result.calculateTotalReward();
        assertThat(totalPrize).isEqualTo(new Money(55_000));
    }

    @Test
    @DisplayName("로또 티켓은 1보다 작은 숫자는 만들어 질 수 없다.")
    public void lottoNumberUnderTest() {
        assertThatThrownBy(() -> {
            LottoNumber.of(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 티켓은 45보다 큰 숫자는 만들어 질 수 없다.")
    public void lottoNumberUpperTest() {
        assertThatThrownBy(() -> {
            LottoNumber.of(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
