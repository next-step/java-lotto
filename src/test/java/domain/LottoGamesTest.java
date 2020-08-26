package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGamesTest {

    @Test
    void makeLottoTicketTest() {
        assertThatThrownBy(() -> new LottoGames().validatePrice(13500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Price ERR");
    }
}
