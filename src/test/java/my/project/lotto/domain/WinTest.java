package my.project.lotto.domain;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created : 2020-11-25 오전 10:01
 * Developer : Seo
 */
class WinTest {
    private Lotto_ record;
    private List<Integer> winningNumbers;
//
//    @BeforeEach
//    void setUp() {
//        record = new Lotto();
//        record.add(1);
//        record.add(2);
//        record.add(3);
//        winningNumbers = new ArrayList<>();
//        winningNumbers.add(1);
//        winningNumbers.add(2);
//        winningNumbers.add(3);
//    }
//
//    @DisplayName("1등 당첨 확인")
//    @Test
//    void givenInfo_thenFindRank1() {
//        record.add(4);
//        record.add(5);
//        record.add(6);
//        winningNumbers.add(4);
//        winningNumbers.add(5);
//        winningNumbers.add(6);
//        Win rank = Win.findRank(record, winningNumbers);
//        assertThat(rank).isEqualTo(Win.FIRST);
//        assertThat(rank.getTitle()).isEqualTo(1);
//        rank.setCount();
//        assertThat(rank.getCount()).isEqualTo(1);
//    }
//
//    @DisplayName("3등 당첨 확인")
//    @Test
//    void givenInfo_thenFindRank3() {
//        record.add(4);
//        record.add(5);
//        record.add(7);
//        winningNumbers.add(4);
//        winningNumbers.add(5);
//        winningNumbers.add(6);
//        Win rank = Win.findRank(record, winningNumbers);
//        assertThat(rank).isEqualTo(Win.THIRD);
//        assertThat(rank.getTitle()).isEqualTo(3);
//        rank.setCount();
//        assertThat(rank.getCount()).isEqualTo(1);
//    }
//
//    @DisplayName("4등 당첨 확인")
//    @Test
//    void givenInfo_thenFindRank4() {
//        record.add(4);
//        record.add(7);
//        record.add(8);
//        winningNumbers.add(4);
//        winningNumbers.add(5);
//        winningNumbers.add(6);
//        Win rank = Win.findRank(record, winningNumbers);
//        assertThat(rank).isEqualTo(Win.FOURTH);
//        assertThat(rank.getTitle()).isEqualTo(4);
//        rank.setCount();
//        assertThat(rank.getCount()).isEqualTo(1);
//    }
//
//    @DisplayName("5등 당첨 확인")
//    @Test
//    void givenInfo_thenFindRank5() {
//        record.add(7);
//        record.add(8);
//        record.add(9);
//        winningNumbers.add(4);
//        winningNumbers.add(5);
//        winningNumbers.add(6);
//        Win rank = Win.findRank(record, winningNumbers);
//        assertThat(rank).isEqualTo(Win.FIFTH);
//        assertThat(rank.getTitle()).isEqualTo(5);
//    }
//
//    @DisplayName("5등 2번 당첨 확인")
//    @Test
//    void givenInfo_thenFindRank5_2() {
//        record.add(7);
//        record.add(8);
//        record.add(9);
//        winningNumbers.add(4);
//        winningNumbers.add(5);
//        winningNumbers.add(6);
//        Win rank = Win.findRank(record, winningNumbers);
//        assertThat(rank).isEqualTo(Win.FIFTH);
//        assertThat(rank.getTitle()).isEqualTo(5);
//        rank.setCount();
//        assertThat(rank.getCount()).isEqualTo(1);
//
//        Lotto record2 = new Lotto();
//        record2.add(1);
//        record2.add(2);
//        record2.add(3);
//        record2.add(10);
//        record2.add(11);
//        record2.add(12);
//        Win rank2 = Win.findRank(record2, winningNumbers);
//        assertThat(rank2).isEqualTo(Win.FIFTH);
//        assertThat(rank2.getTitle()).isEqualTo(5);
//        rank2.setCount();
//        assertThat(rank2.getCount()).isEqualTo(2);
//    }

}