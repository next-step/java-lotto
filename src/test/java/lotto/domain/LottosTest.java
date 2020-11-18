package lotto.domain;

import lotto.domain.exception.NotMatchLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    @DisplayName("Lottos 인스턴스 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 6})
    public void createLottosInstance(int size) {
        //Given
        List<Lotto> lottoNumbers = new ArrayList<>();

        //When
        IntStream.range(0, size).forEach(i -> lottoNumbers.add(new Lotto(1, new LottoAutoMachine())));
        Lottos lottos = new Lottos(lottoNumbers);

        //Then
        assertThat(lottos.hasLottoSize()).isEqualTo(size);
    }

    @DisplayName("특정 index에 해당하는 Lotto를 반환하는 테스트")
    @Test
    public void indexGetLotto(){

        //Given
        LottoTicket ticket = LottoShop.purchase(10000);
        Lottos lottos = LottoShop.exchangeToLotto(ticket, new LottoAutoMachine());

        //When
        List<Integer> result = lottos.getLottoNumber(9);

        //Then
        assertThat(result).isNotNull();
    }


    @DisplayName("당첨번호 확인 후 Reward 인스턴스 생성 여부 테스트")
    @Test
    public void matchPrizeNumberTest() {

        //Given
        LottoTicket ticket = LottoShop.purchase(10000);
        Lottos lottos = LottoShop.exchangeToLotto(ticket, new LottoAutoMachine());
        List<Integer> prizeNumbers = Arrays.asList(12, 35, 33, 22);

        //When
        lottos.matchPrizeNumber(prizeNumbers);

        //Then
        assertThat(lottos.getReward()).isNotNull();
    }

    @DisplayName("당첨번호를 확인하지 않은채 Reward 호출 시 Exception 테스트")
    @Test
    public void beforeGetRewardExceptionText() {
        assertThatThrownBy(() -> {
            Lottos lottos = LottoShop.exchangeToLotto(LottoShop.purchase(5000), new LottoAutoMachine());
            lottos.getReward();
        }).isInstanceOf(NotMatchLottoNumberException.class);
    }
}
