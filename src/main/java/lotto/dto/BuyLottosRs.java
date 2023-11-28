package lotto.dto;

public class BuyLottosRs {

    private final LottosDto lottosDto;
    private final long automaticLottoCount;

    public BuyLottosRs(LottosDto lottosDto, long automaticLottoCount) {
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
