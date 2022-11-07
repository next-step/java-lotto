package lotto.services;

import lotto.models.IssuedLotto;
import lotto.models.enums.IssueType;
import lotto.models.request.IssueLottoRequest;
import lotto.strategy.NormalPickNumberStrategy;
import lotto.strategy.PickNumberStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    private static final LottoService lottoService = new LottoService();

    private static final PickNumberStrategy strategy = new NormalPickNumberStrategy();

    private static final int PAYMENT = 10000;

    private static final List<String> manualLottoNumbers = new ArrayList<>();

    @BeforeAll
    public static void setManualLottoNumbers() {
        manualLottoNumbers.add("1, 2, 3, 4, 5, 6");
        manualLottoNumbers.add("1, 2, 3, 4, 5, 7");
        manualLottoNumbers.add("1, 2, 3, 4, 5, 8");
    }

    @Test
    @DisplayName("issueLottos는 지급한 금액에 알맞는 개수만큼의 로또를 발급한다.")
    void test1() {
        IssueLottoRequest issueLottoRequest = IssueLottoRequest.of(PAYMENT, manualLottoNumbers);
        List<IssuedLotto> issuedLottos = lottoService.issueLottos(issueLottoRequest, strategy);

        assertThat(issuedLottos.size()).isEqualTo(PAYMENT / IssuedLotto.PRICE);
    }

    @Test
    @DisplayName("issueLottoRequest에 manualLottoNumbers가 없는 경우 IssueType.random인 로또만 생성된다.")
    void test2() {
        IssueLottoRequest issueLottoRequest = IssueLottoRequest.of(PAYMENT, new ArrayList<>());
        List<IssuedLotto> issuedLottos = lottoService.issueLottos(issueLottoRequest, strategy);

        long randomIssuedLottoCount = issuedLottos
                .stream()
                .filter(lotto -> lotto.getIssueType().equals(IssueType.RANDOM))
                .count();
        assertThat(randomIssuedLottoCount).isEqualTo(PAYMENT / IssuedLotto.PRICE);
    }

    @Test
    @DisplayName("지급한 금액에 딱 맞는 만큼 수동 번호를 입력하는 경우 IssueType.manual인 로또만 생성된다.")
    void test3() {
        int payment = manualLottoNumbers.size() * IssuedLotto.PRICE;
        IssueLottoRequest issueLottoRequest = IssueLottoRequest.of(payment, manualLottoNumbers);
        List<IssuedLotto> issuedLottos = lottoService.issueLottos(issueLottoRequest, strategy);

        long manualIssuedLottoCount = issuedLottos
                .stream()
                .filter(lotto -> lotto.getIssueType().equals(IssueType.MANUAL))
                .count();
        assertThat(manualIssuedLottoCount).isEqualTo(payment / IssuedLotto.PRICE);
    }

}
