package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoPublisherTest {
    private LottoPublisher publisher;
    private LottoPublisher pubchasePublisher;

    @BeforeEach
    void setUp() {
        publisher = new LottoPublisher();
        pubchasePublisher = new LottoPublisher(14000);
    }

    @Test
    void IllegalArgumentException_투입금액유효성검사() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            publisher.validatePurchaseAmount(0);
            publisher.validatePurchaseAmount(-1000);
            publisher.validatePurchaseAmount(11500);
        });
    }

    @Test
    void 구매한로또개수확인() {
        assertThat(pubchasePublisher.getBuyLottoCount()).isEqualTo(14);
    }

    @Test
    void 생성자금액만큼로또생성() {
        assertThat(pubchasePublisher.getPublishLotto().size()).isEqualTo(14);
    }

    @Test
    void 생성한로또숫자콘솔출력() {
        for (int i = 0 ; i < pubchasePublisher.getBuyLottoCount(); i++) {
            List<Integer> numbers = pubchasePublisher.getPublishLotto().get(i).getNumbers();
            List<String> strNumbers = new ArrayList<>();
            for (int j = 0 ; j < 6; j++) {
                strNumbers.add(numbers.get(j).toString());
            }
            System.out.println((i+1)+"로또번호["+String.join(",", strNumbers)+"]");
        }
    }
}
