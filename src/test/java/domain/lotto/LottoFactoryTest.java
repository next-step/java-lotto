package domain.lotto;

import domain.common.Money;
import domain.lotto.genrate.CustomLottoGenerator;
import domain.lotto.genrate.LottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {

    LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator() {

            @Override
            public List<Integer> create() {
                return List.of(1, 2, 3, 4, 5, 6);
            }

            @Override
            public int getSize() {
                return 1;
            }
        };
    }

    @DisplayName("로또 금액과 로또 생성전략으로 로또를 생성할 수 있다.")
    @Test
    void create() {

        LottoFactory lottoFactory = new LottoFactory(List.of(lottoGenerator));
        UserLotto userLotto = lottoFactory.createUserLotto();
        Assertions.assertThat(userLotto.lottoList()).isEqualTo(List.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6))));
    }

    @DisplayName("수동 생성전략으로 유저 로또를 생성할 수 있다.")
    @Test
    void createWithCustomLotto() {
        CustomLottoGenerator customLottoGenerator = new CustomLottoGenerator(List.of(List.of(1, 2, 3, 4, 5, 6)));
        LottoFactory lottoFactory = new LottoFactory(List.of(customLottoGenerator));
        UserLotto userLotto = lottoFactory.createUserLotto();
        Assertions.assertThat(userLotto.lottoList()).isEqualTo(List.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6))));
    }
}
