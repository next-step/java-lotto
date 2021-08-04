package lotto.domain;

import lotto.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTests {

    @DisplayName("로또 결과를 잘 가져오는지 테스트")
    @Test
    void getLottoResultTest() {
        LottoNumbers lottoNumbers = LottoNumbers.of(new TreeSet<>(Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))));

        LottoNumbers winningLottoNumbers = LottoNumbers.of(new TreeSet<>(Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))));

        LottoNumber bonusLottoNumber = LottoNumber.of(7);

        Set<LottoNumbers> totalLottoNumbers = new HashSet<>();

        totalLottoNumbers.add(lottoNumbers);

        LottoResult lottoResult = LottoResult.of(CollectionOflLottoNumbers.of(totalLottoNumbers), winningLottoNumbers, bonusLottoNumber);

        assertThat(lottoResult.getLottoResult().get(LottoRank.ALL_MATCH)).isEqualTo(1);
    }

    @DisplayName("로또 2등 일 때 결과를 잘 가져오는지 테스트")
    @Test
    void getLottoResultSecondPriceTest() {
        LottoNumbers lottoNumbers = LottoNumbers.of(new TreeSet<>(Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(7))));

        LottoNumbers winningLottoNumbers = LottoNumbers.of(new TreeSet<>(Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(8))));

        LottoNumber bonusLottoNumber = LottoNumber.of(7);

        Set<LottoNumbers> totalLottoNumbers = new HashSet<>();

        totalLottoNumbers.add(lottoNumbers);

        LottoResult lottoResult = LottoResult.of(CollectionOflLottoNumbers.of(totalLottoNumbers), winningLottoNumbers, bonusLottoNumber);

        assertThat(lottoResult.getLottoResult().get(LottoRank.FIVE_MATCH_WITH_BONUS)).isEqualTo(1);
    }

    @DisplayName("로또 3등 일 때 결과를 잘 가져오는지 테스트")
    @Test
    void getLottoResultThirdPriceTest() {
        LottoNumbers lottoNumbers = LottoNumbers.of(new TreeSet<>(Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(9))));

        LottoNumbers winningLottoNumbers = LottoNumbers.of(new TreeSet<>(Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(8))));

        LottoNumber bonusLottoNumber = LottoNumber.of(7);

        Set<LottoNumbers> totalLottoNumbers = new HashSet<>();

        totalLottoNumbers.add(lottoNumbers);

        LottoResult lottoResult = LottoResult.of(CollectionOflLottoNumbers.of(totalLottoNumbers), winningLottoNumbers, bonusLottoNumber);

        assertThat(lottoResult.getLottoResult().get(LottoRank.FIVE_MATCH)).isEqualTo(1);
    }

    @DisplayName("결과로 수익 계산이 올바른 지 테스트")
    @Test
    void validLottoCalculateProfitTest() {
        LottoNumbers lottoNumbers = LottoNumbers.of(new TreeSet<>(Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))));

        LottoNumbers winningLottoNumbers = LottoNumbers.of(new TreeSet<>(Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))));

        LottoNumber bonusLottoNumber = LottoNumber.of(7);

        Set<LottoNumbers> totalLottoNumbers = new HashSet<>();

        totalLottoNumbers.add(lottoNumbers);

        LottoResult lottoResult = LottoResult.of(CollectionOflLottoNumbers.of(totalLottoNumbers), winningLottoNumbers, bonusLottoNumber);

        assertThat(lottoResult.calculateProfitRate(14000)).isEqualTo(142857.14285714287);
    }
}
