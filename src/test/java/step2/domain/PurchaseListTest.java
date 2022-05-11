package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "구매 목록 테스트")
class PurchaseListTest {

    @Test
    void 구매금액과_수동_입력번호를_받아서_객체_생성() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(10000, 2);
        String numbers1 = "1, 2, 3, 4, 5, 6";
        String numbers2 = "7, 8, 9, 10, 11, 12";
        List<Lotto> expect = List.of(new Lotto(numbers1), new Lotto(numbers2));

        PurchaseList purchaseList = new PurchaseList(purchaseMoney, List.of(numbers1, numbers2));

        assertAll(
                () -> assertThat(purchaseList).extracting("values").asList().doesNotContainNull(),
                () -> assertThat(purchaseList).extracting("values").asList().hasSize(10),
                () -> assertThat(purchaseList).extracting("values").asList().containsAll(expect)
        );
    }
}