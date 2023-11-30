package lotto.dto;

public class BuyLottosResponse {

    private final LottosDto lottosDto;
    private final long automaticLottoCount;

    public BuyLottosResponse(LottosDto lottosDto, long automaticLottoCount) {
        this.lottosDto = lottosDto;
        this.automaticLottoCount = automaticLottoCount;
    }

    public LottosDto getLottosDto() {
        return lottosDto;
    }

    public long getAutomaticLottoCount() {
        return automaticLottoCount;
    }
}
