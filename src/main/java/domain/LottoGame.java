package domain;

public class LottoGame {

    private static final int LOTTO_TICKET_PRICE = 1000;
    private int ticketCount;
    private int monkey;
    private LottoList lottoList;
    private LottoNumbers winNumbers;

    public LottoGame(int monkey, LottoNumbers winNumbers) {
        this.monkey = monkey;
        int ticketCount = monkey / LOTTO_TICKET_PRICE;
        lottoList = new LottoList(ticketCount);
        this.winNumbers = winNumbers;
    }

    public LottoResultResponse convert(){
        return LottoResultResponse
            .builder
            .lottoResultResponse()
            .lottoList(this.lottoList)
            .ticketCount(this.ticketCount)
            .monkey(this.monkey)
            .winNumbers(winNumbers)
            .build();
    }
}
