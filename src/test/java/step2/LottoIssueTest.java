package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step2.domain.LottoTicket;
import step2.domain.LottoTicketMachine;
import step2.streategy.TestNumberMakeStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoIssueTest {
    private LottoTicketMachine lottoTicketMachine;
    private TestNumberMakeStrategy testNumberMakeStrategy;
    @BeforeEach
    void setup(){
        lottoTicketMachine = new LottoTicketMachine();
        testNumberMakeStrategy = new TestNumberMakeStrategy();
    }


    @DisplayName("입력한 금액에 맞는 로또 구매 횟수 반환 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "7000:7", "14000:14"}, delimiter = ':')
    void issuanceLotto(int inputPrice, int resultLottoCount) {
        int allowCount = lottoTicketMachine.countAllowTicket(inputPrice);
        assertThat(allowCount).isEqualTo(resultLottoCount);
    }

    @DisplayName("로또 발급 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoMarkingNumbers")
    void issuanceLotto(List<Integer> input, String resultValue) {
        testNumberMakeStrategy.setupTestValue(input);
        LottoTicket lottoTicket = new LottoTicket(testNumberMakeStrategy);
        assertThat(lottoTicket.getMarkingNumbers()).isEqualTo(resultValue);
        for (Integer value : input) {
            assertThat(lottoTicket.isMarked(value)).isTrue();
        }

    }
    private static Stream<Arguments> provideLottoMarkingNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6), "[1, 2, 3, 4, 5, 6]"),
                Arguments.of(Arrays.asList(6,5,4,3,2,1), "[6, 5, 4, 3, 2, 1]")
        );
    }
}
