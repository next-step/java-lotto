package lotto.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.store.Budget;
import lotto.store.ManualCount;

class ManualGameDtoTest {

    @Test
    @DisplayName(value = "price 를 받아 수동 구매 개수가 전체 구매 개수를 초과하면 IllegalArgumentException 을 일으킨다")
    void isValidManualCountByPrice() {
        ManualGameDto manualGameDto = new ManualGameDto(new Budget(10_000), new ManualCount(11));
        int price = 1_000;
        assertThrows(IllegalArgumentException.class,
            () -> manualGameDto.isValidManualCountBy(price));
    }

}