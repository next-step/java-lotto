package lotto.domain.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lotto.domain.exception.NullLottoBallsListException;

public class MarkingPaper {

    private final List<LottoBalls> markedBalls = new ArrayList<>();

    public void markLottoBalls(LottoBalls lottoBalls) {
        this.markedBalls.add(Optional.ofNullable(lottoBalls)
                .orElseThrow(NullLottoBallsListException::new));
    }

    public int getMarkingSize() {
        return markedBalls.size();
    }

    public List<Ticket> convertPapersToTickets() {
        return markedBalls.stream()
                .map(Ticket::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public void clear() {
        markedBalls.clear();
    }
}
