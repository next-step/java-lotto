package my.project.lotto.domain;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StatInfoTest {
//    private List<Lotto_> records;
//    private List<Integer> winningNumbers;
/*
    @BeforeEach
    void setUp() {
        Lotto record = new Lotto();
        record.add(1);
        record.add(2);
        record.add(3);
        record.add(4);
        record.add(5);
        record.add(6);
        records = new ArrayList<>();
        records.add(record);

        winningNumbers = new ArrayList<>();
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);
    }

    @DisplayName("인스턴스 확인")
    @Test
    void init() {
        StatInfo info = new StatInfo(records, winningNumbers);
        assertThat(info)
                .isNotNull()
                .isInstanceOf(StatInfo.class);
    }

    @DisplayName("null을 전달할 경우 IllegalArgumentException 예외가 발생해야 한다")
    @ParameterizedTest
    @NullAndEmptySource
    void givenNull_thenThrowException(List<Lotto> record) {
        assertThatThrownBy(() -> new StatInfo(record, winningNumbers))
                .withFailMessage("데이터가 없습니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("null을 전달할 경우 IllegalArgumentException 예외가 발생해야 한다")
    @ParameterizedTest
    @NullAndEmptySource
    void givenNull_thenThrowException2(List<Integer> winningNumbers) {
        assertThatThrownBy(() -> new StatInfo(records, winningNumbers))
                .withFailMessage("데이터가 없습니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }*/

}