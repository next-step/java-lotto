package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoMatch;
import lotto.domain.LottoMatchResult;
import lotto.domain.LottoNum;
import lotto.domain.LottoNums;
import lotto.domain.LottoSeller;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTest {

    @DisplayName("로또를 한개이상 구입할수있다.")
    @ParameterizedTest
    @CsvSource(value = {
        "1000,1",
        "2000,2",
        "3000,3"
    })
    void buy_many_lotto(long price, int count) {
        LottoSeller lottoSeller = new LottoSeller();
        Lottos lottos = lottoSeller.sell(price);

        assertThat(lottos.getCount()).isEqualTo(count);
    }

    @DisplayName("로또는 6개의 숫자가 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,7,10})
    void given_not_6_when_lotto_create_then_throw_exception(int numCount) {
        List<LottoNum> lottoNumList = IntStream.range(1,numCount+1).mapToObj(value -> new LottoNum(value)).collect(
            Collectors.toList());

        assertThatThrownBy(()->new LottoNums(lottoNumList))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또는 6개의 숫자의 숫자를 가진다.")
    @Test
    void given_6_nums_when_lotto_create_then_success() {
        List<LottoNum> lottoNumList = IntStream.range(1,7).mapToObj(value -> new LottoNum(value)).collect(Collectors.toList());
        new LottoNums(lottoNumList);
    }

    @DisplayName("로또는 1부터 45까지의 수가 아니면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0,-1,46})
    void given_not_1_to_45_num_when_lotto_num_create_then_throw_exception(int lottoNum){
        assertThatIllegalArgumentException()
            .isThrownBy(()->new LottoNum(lottoNum));
    }

    @DisplayName("로또는 1부터 45까지의 수를 가지고 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1,3,45})
    void given_1_to_45_num_when_lotto_num_create_then_success(int lottoNum){
        new LottoNum(lottoNum);
    }

    @DisplayName("로또가 몇게가 일치하는지 알수 있다.")
    @Test
    void match_count(){
        List<LottoNum> lottoNumList = IntStream.range(1,7).mapToObj(value -> new LottoNum(value)).collect(Collectors.toList());

        LottoNums lottoNums = new LottoNums(lottoNumList);
        Lotto lotto = new Lotto(lottoNums);

        assertThat(lotto.getLottoMatch(lottoNums).get()).isEqualTo(LottoMatch.SIX);
    }

    @DisplayName("로또의 번호가 중복될경우 예외가 발생한다.")
    @Test
    void rotto_nums_not_duplicated(){
        List<LottoNum> lottoNumList = Stream.generate(() -> new LottoNum(1)).limit(6).collect(
            Collectors.toList());

        assertThatThrownBy(()->new LottoNums(lottoNumList))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또들의 결과를 조회할수있다.")
    @Test
    void lotto_result() {
        List<LottoNum> lottoNumList = IntStream.range(1, 7).mapToObj(value -> new LottoNum(value))
            .collect(Collectors.toList());

        LottoNums lottoNums = new LottoNums(lottoNumList);
        Lotto lotto = new Lotto(lottoNums);
        Lottos lottos = new Lottos(Arrays.asList(lotto));

        LottoMatchResult lottoMatchResult = lottos.getResult(lottoNums, 1000);
        assertThat(lottoMatchResult.get(LottoMatch.SIX)).isEqualTo(1L);
    }

    @DisplayName("로또의 수익률을 계산할수있다.")
    @Test
    void profit_rate() {
        List<LottoNum> lottoNumList = IntStream.range(1, 7).mapToObj(value -> new LottoNum(value))
            .collect(Collectors.toList());

        LottoNums lottoNums = new LottoNums(lottoNumList);
        Lotto lotto = new Lotto(lottoNums);
        Lottos lottos = new Lottos(Arrays.asList(lotto));

        LottoMatchResult lottoMatchResult = lottos.getResult(lottoNums, 1000);
        assertThat(lottoMatchResult.computeProfitRate()).isEqualTo(1_500_000/1000);
    }

}

