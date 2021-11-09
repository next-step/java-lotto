package lotto.service;

import lotto.service.domain.LottoTicket;
import lotto.service.domain.LottoTicketMaker;
import lotto.service.domain.types.Rank;
import lotto.service.dto.LottoPurchaseDTO;
import lotto.service.dto.LottoResultCreateDTO;
import lotto.service.model.LottoResult;
import lotto.service.model.LottoTickets;
import lotto.service.value.LottoNumber;
import lotto.utils.Preconditions;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    private static final Integer START_LOTTO_QUANTITY = 1;
    private final LottoTicketMaker lottoTicketMaker;

    public LottoService(LottoTicketMaker lottoTicketMaker) {
        this.lottoTicketMaker = lottoTicketMaker;
    }

    public LottoTickets purchaseLottoTickets(LottoPurchaseDTO lottoPurchaseDTO) {
        Preconditions.checkNotNull(lottoPurchaseDTO, "lottoPurchaseDTO의 값이 없습니다.");

        List<LottoTicket> lottoTickets = IntStream.rangeClosed(START_LOTTO_QUANTITY,
                                                               lottoPurchaseDTO.getLottoQuantity())
                .mapToObj(v -> lottoTicketMaker.createLottoTicket())
                .collect(Collectors.toList());
        return LottoTickets.from(lottoTickets);
    }

    public LottoTicket getWinningLottoTicket(List<Integer> winningLottoNumbers) {
        Preconditions.checkNotNull(winningLottoNumbers, "winningNumbers의 값이 없습니다.");

        List<LottoNumber> numbers = winningLottoNumbers.stream()
                .sorted()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
        return LottoTicket.from(numbers);
    }

    public LottoResult checkLottoResult(LottoResultCreateDTO lottoResultCreateDTO) {
        Preconditions.checkNotNull(lottoResultCreateDTO, "lottoResultCreateDTO의 값이 없습니다.");

        return checkLottoResult(lottoResultCreateDTO.getPurchaseLottoTickets(),
                                lottoResultCreateDTO.getWinningLottoTicket());
    }

    private LottoResult checkLottoResult(LottoTickets purchaseLottoTickets, LottoTicket winningLottoTicket) {
        List<Integer> countOfMatches = purchaseLottoTickets.getCountOfMatches(winningLottoTicket);

        Map<Rank, Integer> countOfMatchesMap = countOfMatches.stream()
                .map(Rank::valueOf)
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));

        return LottoResult.from(countOfMatchesMap);
    }
}
