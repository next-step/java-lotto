package lotto.services;

import lotto.strategy.NormalPickNumberStrategy;
import lotto.strategy.PickNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    private static final LottoService lottoService = new LottoService();

    private static final PickNumberStrategy strategy = new NormalPickNumberStrategy();

}
