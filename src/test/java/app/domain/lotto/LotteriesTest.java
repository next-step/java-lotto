package app.domain.lotto;

import app.action.LottoMachine;
import app.strategy.LottoNumStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LotteriesTest {

    private static LottoNumStrategy strategy;
    private static LottoMachine machine;
    private static Lotteries lottoList;

    @DisplayName("로또머신 임시로 생성")
    @BeforeAll
    static void makeMachine() {
        strategy = new LottoNumStrategy() {
            @Override
            public Lotto makeLotto() {
                return Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
            }
        };
        machine = LottoMachine.of(strategy);
    }

    @DisplayName("로또 리스트 계속 초기화")
    @BeforeEach
    void makeList() {
        lottoList = Lotteries.create();
    }

    @DisplayName("객체가 생성되었는지 확인한다.")
    @Test
    void createListTest() {
        assertThat(lottoList).isNotEqualTo(null);
    }

    @DisplayName("리스트 객체 생성시 길이는 0")
    @Test
    void checkListSizeTest() {
        assertThat(lottoList.getSize()).isEqualTo(0);
    }

    @DisplayName("로또가져올때 인덱스 넘는값 입력시 에러 발생.")
    @Test
    void isOutOfIndexList() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> lottoList.getLotto(1)
        ).withMessageContaining("초과");
    }

    @DisplayName("머신으로 로또 추가하기.")
    @Test
    void insertStrategyTest() {
        lottoList.buyLotto(machine);

        assertThat(lottoList.getSize()).isEqualTo(1);
        assertThat(lottoList.getLotto(0))
                .isEqualTo(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

}