package study.step4.domain;

import study.step4.dto.LottoInputDto;
import study.step4.dto.LottoOutputDto;

public class LottoShop {
    private static final int LOTTO_PRICE_PER_PIECE = 1000;
    private static final int ZERO_COUNT = 0;
    private static final String LOTTO_PRICE_EXCEPTION = "로또 구매 금액은 1000원 보다 작을 수 없습니다.";

    public static LottoOutputDto buyLottos(LottoInputDto lottoInputDto){
        validatePrice(lottoInputDto.getPrice());
        LottoTickets lottos = buyAutoTickets(lottoInputDto);
        if (IsManualNotZero(lottoInputDto)) {
            LottoTickets manualLottos = buyManualTickets(lottoInputDto);
            lottos.merge(manualLottos);
        }
        return new LottoOutputDto(lottos,
                lottos.countLottoTickets(), lottoInputDto.getManualAmount());
    }

    private static void validatePrice(long price) {
        if (price < LOTTO_PRICE_PER_PIECE){
            throw new IllegalArgumentException(LOTTO_PRICE_EXCEPTION);
        }
    }

    private static LottoTickets buyAutoTickets(LottoInputDto lottoInputDto) {
        return LottoTickets.autoPublish(calculateAutoLottoCounting(lottoInputDto));
    }

    private static boolean IsManualNotZero(LottoInputDto lottoInputDto) {
        return lottoInputDto.getManualAmount() > ZERO_COUNT;
    }

    private static LottoTickets buyManualTickets(LottoInputDto lottoInputDto) {
        return LottoTickets.manualPublish(lottoInputDto);
    }

    public static long calculateAutoLottoCounting(LottoInputDto lottoInputDto) {
        return countTotalLottoTicket(lottoInputDto.getPrice()) - lottoInputDto.getManualAmount();
    }

    private static long countTotalLottoTicket(long price) {
        return Math.floorDiv(price, LOTTO_PRICE_PER_PIECE);
    }
}
