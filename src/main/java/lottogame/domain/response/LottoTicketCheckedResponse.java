package lottogame.domain.response;

import java.util.Objects;

public class LottoTicketCheckedResponse {

    private final int matchedCount;
    private final int money;

    public LottoTicketCheckedResponse(int matchedCount, int money) {
        this.matchedCount = matchedCount;
        this.money = money;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoTicketCheckedResponse)) {
            return false;
        }
        LottoTicketCheckedResponse that = (LottoTicketCheckedResponse) o;
        return matchedCount == that.matchedCount && money == that.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchedCount, money);
    }

    @Override
    public String toString() {
        return "LottoTicketCheckResponse{" +
            "matchedCount=" + matchedCount +
            ", money=" + money +
            '}';
    }
}
