package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "구매 목록 테스트")
class PurchaseListTest {

    @Test
    void 구매_갯수를_입력으로_받아_갯수만큼_로또를_생성합니다() {
        assertThat(new PurchaseList(3).getValues()).hasSize(3);
    }
}