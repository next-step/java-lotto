package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static lotto.model.LottoFactory.create;
import static org.assertj.core.api.Assertions.assertThat;

class ManualPurchaseTest {
    private LottoMachine machine;

    @BeforeEach
    void setUp() {
        machine = new ManualPurchase(new Scanner(System.in));
    }

    @Test
    void 수동구매_요청수량이_0인경우_빈배열을_반환한다() {
        List<Lotto> lottos = machine.purchase(0);

        assertThat(lottos).isEmpty();
    }

    @Test
    void 수동구매_수량과_입력에따라_로또생성하여_반환한다() {
        String given = "8, 21, 23, 41, 42, 43\n3, 5, 11, 16, 32, 38\n7, 11, 16, 35, 36, 44";
        InputStream in = new ByteArrayInputStream(given.getBytes());
        System.setIn(in);

        List<Lotto> lottos = machine.purchase(3);

        assertThat(lottos).hasSize(3)
                .containsExactly(create(8, 21, 23, 41, 42, 43), create(3, 5, 11, 16, 32, 38), create(7, 11, 16, 35, 36, 44));
    }

}
