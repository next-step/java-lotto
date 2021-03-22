package domain;

public class LottoResultResponse {

    private final LottoList lottoList;
    private final int ticketCount;
    private final int monkey;
    private LottoNumbers winNumbers;
    private int winningsPrice;
    private double yield;

    public LottoResultResponse(LottoList lottoList, int ticketCount, int monkey, LottoNumbers winNumbers) {
        this.lottoList = lottoList;
        this.ticketCount = ticketCount;
        this.monkey = monkey;
        this.winNumbers = winNumbers;
        this.winningsPrice = 0;
        this.yield = 0;
    }

    public LottoList getLottoList() {
        return lottoList;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public int getMonkey() {
        return monkey;
    }

    public LottoNumbers getWinNumbers() {
        return winNumbers;
    }

    public int getWinningsPrice() {
        return winningsPrice;
    }

    public double getYield() {
        return yield;
    }

    public static final class builder {
        private LottoList lottoList;
        private int ticketCount;
        private int monkey;
        private LottoNumbers winNumbers;

        private builder() {
        }

        public static builder lottoResultResponse() {
            return new builder();
        }

        public builder lottoList(LottoList lottoList) {
            this.lottoList = lottoList;
            return this;
        }

        public builder ticketCount(int ticketCount) {
            this.ticketCount = ticketCount;
            return this;
        }

        public builder monkey(int monkey) {
            this.monkey = monkey;
            return this;
        }

        public builder winNumbers(LottoNumbers winNumbers) {
            this.winNumbers = winNumbers;
            return this;
        }

        public LottoResultResponse build() {
            return new LottoResultResponse(lottoList, ticketCount, monkey, winNumbers);
        }
    }
}
