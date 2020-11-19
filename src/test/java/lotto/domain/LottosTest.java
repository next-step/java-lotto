package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(lottos.quantity()).isEqualTo(size);
    }

    @DisplayName("특정 index에 해당하는 Lotto 숫자를 반환하는 테스트")
    @Test
    public void indexGetLotto() {

        //Given
        LottoShop lottoShop = new LottoShop();
        Lottos lottos = lottoShop.purchase(5000, new LottoMachine() {
            @Override
            List<Integer> createLottoNumber() {
                return Arrays.asList(1, 3, 5, 6, 7, 8);
            }
        });

        //When
        List<Integer> result = lottos.getLottoNumber(3);

        //Then
        assertThat(result).isNotNull();
        assertThat(new HashSet(result)).hasSize(result.size());
    }



    @DisplayName("당첨번호 확인 후 Reward 인스턴스 생성 여부 테스트")
    @Test
    public void matchPrizeNumberTest() {

        //Given
        LottoShop lottoShop = new LottoShop();
        Lottos lottos = lottoShop.purchase(10000, new LottoMachine() {
            @Override
            List<Integer> createLottoNumber() {
                return Arrays.asList(12, 33, 35, 45);
            }
        });

        //When
        Reward reward = lottos.matchPrizeNumber(Arrays.asList(12, 35, 33, 22));

        //Then
        assertThat(reward).isNotNull();

    }
}