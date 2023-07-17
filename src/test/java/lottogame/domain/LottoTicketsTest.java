package lottogame.domain;

import lottogame.domain.spi.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@SuppressWarnings("FieldCanBeLocal")
@DisplayName("LottoTickets 클래스")
class LottoTicketsTest {

    @Nested
    @DisplayName("new 생성자는")
    class Describe_XXX_Method {

        @Nested
        @DisplayName("생성할 n개의 로또와 수동 로또번호들를 입력하면")
        class Context_Input_Total_Count_And_Manual_Lotto_Numbers_List {

            private final NumberGenerator numberGenerator = (count) -> Set.of(1,2,3,4,5,6);
            private final LottoTickets lottoTickets = new LottoTickets(10, List.of(Set.of(1,2,3,4,5,6)), numberGenerator);

            @Test
            @DisplayName("수동로또번호 리스트의 size 갯수의 수동 로또와 n - size 만큼의 자동 로또를 생성한다")
            void It_create_Manual_And_Auto_LottoTickets () {

                assertThat(lottoTickets.getManualLottoTickets()).hasSize(1);
                assertThat(lottoTickets.getAutoLottoTickets()).hasSize(9);
                assertThat(lottoTickets.getLottoTickets()).hasSize(10);
            }
        }

        @Nested
        @DisplayName("total count 보다 넘는 수동 로또번호들을 입력하면")
        class Context_Input_Manual_Lotto_Numbers_List_Over_Total_Count {

            private final NumberGenerator numberGenerator = (count) -> Set.of(1,2,3,4,5,6);
            private final List<Set<Integer>> manualLottoNumbersListOverTotalCount = List.of(Set.of(1,2,3,4,5,6), Set.of(1,2,3,4,5,6));

            @Test
            @DisplayName("IllegalArgumentException을 던진다")
            void It_Throw_IllegalArgumentException() {
                assertThatThrownBy(() ->
                        new LottoTickets(1, manualLottoNumbersListOverTotalCount, numberGenerator))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }
}
