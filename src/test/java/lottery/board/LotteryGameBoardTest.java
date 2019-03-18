package lottery.board;

import lottery.domain.LotteryRank;
import org.junit.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryGameBoardTest {

    @Test
    public void test_로또_구매_랜덤번호() {
        LotteryGameBoard board = new LotteryGameBoard();

        assertThat(board.buyLotteryTicket(14000)).isEqualTo(14);
    }

    @Test
    public void test_로또_구매_지정번호() {
        LotteryGameBoard board = new LotteryGameBoard(size -> Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(board.buyLotteryTicket(14000)).isEqualTo(14);
    }

    @Test
    public void test_로또_구매_지정번호_당첨_1등_2개() {
        Supplier<List<Integer>> winningNumbersSupplier = () -> Arrays.asList(1, 2, 3, 4, 5, 6);
        LotteryGameBoard board = new LotteryGameBoard(size -> winningNumbersSupplier.get());

        final List<Integer> winningNumbers = winningNumbersSupplier.get();
        board.buyLotteryTicket(2000);

        assertThat(board.checkWinningNumbers(winningNumbers))
                .isEqualTo(Arrays.asList(LotteryRank.FIRST, LotteryRank.FIRST));
    }
}
