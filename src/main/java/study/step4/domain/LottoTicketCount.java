package study.step4.domain;

import java.util.Objects;

public class LottoTicketCount {
    private final int lottoTicketCount;

    public LottoTicketCount(String lottoTicketCount) {
        this(Integer.parseInt(lottoTicketCount));
    }

    public LottoTicketCount(int lottoTicketCount) {
        valid(lottoTicketCount);
        this.lottoTicketCount = lottoTicketCount;
    }

    private void valid(int count) {
        if(count < 0) {
            throw new IllegalArgumentException("0보다 큰 값을 입력하세요");
        }
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LottoTicketCount that = (LottoTicketCount)o;
        return lottoTicketCount == that.lottoTicketCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTicketCount);
    }
}
