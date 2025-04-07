package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoGame {

    public Lotto[] buyLottos(LottoTickets tickets, List<LottoNumbers> manualLottoNumbersList) {
        if (tickets.getManualTicketCount() != manualLottoNumbersList.size()) {
            throw new IllegalArgumentException("수동 구매 로또 수만큼의 LottoNumbers가 입력되지 않았습니다.");
        }
        return Stream.concat(
                IntStream.range(0, tickets.getAutoTicketCount())
                        .mapToObj(i -> new Lotto()),
                manualLottoNumbersList
                        .stream()
                        .map(numbers -> new Lotto(numbers))
        ).toArray(Lotto[]::new);

    }

    public WinningLotto getWinningLotto(int[] winningLottoNumbers, int bonusNumber) {
        return new WinningLotto(
                new Lotto(new LottoNumbers(winningLottoNumbers)),
                new LottoNumber(bonusNumber)
        );
    }

    public LottoRank[] getResults(Lotto[] lottos, WinningLotto winningLotto) {
        return Arrays.stream(lottos)
                .map(winningLotto::getRank)
                .toArray(LottoRank[]::new);
    }
}
