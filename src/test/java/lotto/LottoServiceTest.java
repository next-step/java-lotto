package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberList;
import lotto.domain.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        this.lottoService = new LottoService();
    }

    @DisplayName("Money를 넘기면 1000원짜리 로또를 몇개 구입했는지 반환한다.")
    @Test
    void lotto_purchase_count() {
        assertThat(lottoService.purchaseNumber(new Money(3000))).isEqualTo(3);
    }

    @DisplayName("당첨번호와 일치하는 갯수 배열을 반환한다.")
    @Test
    void check_lotto() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(LottoNumberList.createLottoNumbers(new int[]{1, 2, 3, 4, 5, 6})),
                new Lotto(LottoNumberList.createLottoNumbers(new int[]{2, 3, 4, 5, 6, 7})),
                new Lotto(LottoNumberList.createLottoNumbers(new int[]{3, 4, 5, 6, 7, 8})),
                new Lotto(LottoNumberList.createLottoNumbers(new int[]{4, 5, 6, 7, 8, 9})),
                new Lotto(LottoNumberList.createLottoNumbers(new int[]{5, 6, 7, 8, 9, 10})),
                new Lotto(LottoNumberList.createLottoNumbers(new int[]{6, 7, 8, 9, 10, 11})),
                new Lotto(LottoNumberList.createLottoNumbers(new int[]{7, 8, 9, 10, 11, 12}))
        );
        Lotto winner = new Lotto(LottoNumberList.createLottoNumbers(new int[]{1, 2, 3, 4, 5, 6}));

        assertThat(lottoService.checkLotto(lottoList, winner)).isEqualTo(new int[]{1, 1, 1, 1, 1, 1, 1});
    }

    @DisplayName("로또 수익률을 반환한다.")
    @Test
    void yield() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(LottoNumberList.createLottoNumbers(new int[]{4, 5, 6, 7, 8, 9})),
                new Lotto(LottoNumberList.createLottoNumbers(new int[]{5, 6, 7, 8, 9, 10})),
                new Lotto(LottoNumberList.createLottoNumbers(new int[]{6, 7, 8, 9, 10, 11})),
                new Lotto(LottoNumberList.createLottoNumbers(new int[]{7, 8, 9, 10, 11, 12}))
        );
        Lotto winner = new Lotto(LottoNumberList.createLottoNumbers(new int[]{1, 2, 3, 4, 5, 6}));

        assertThat(lottoService.yield(lottoList, winner, new Money(10000))).isEqualTo(0.5);
    }
}
