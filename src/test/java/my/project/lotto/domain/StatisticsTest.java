package my.project.lotto.domain;

import my.project.lotto.controller.LottoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {
    private StatInfo info;
    private Statistics stat;

    @BeforeEach
    void setUp() {
        GameRecord record = new GameRecord();
        record.add(1);
        record.add(2);
        record.add(3);
        record.add(4);
        record.add(5);
        record.add(6);
        List<GameRecord> records = new ArrayList<>();
        records.add(record);

        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);

        this.info = new StatInfo(records, winningNumbers);
        this.stat = new Statistics();
    }

    @DisplayName("인스턴스 확인")
    @Test
    void whenCalled_shouldBe() {
        assertThat(stat.analyze(info))
                .isNotNull()
                .isInstanceOf(StatRecord.class);
    }

    @DisplayName("5등 당첨 확인")
    @Test
    void whenFifthPlace_shouldRecord() {
        assertThat(stat.analyze(info).getFifthPlace()).isEqualTo(1);
    }

}