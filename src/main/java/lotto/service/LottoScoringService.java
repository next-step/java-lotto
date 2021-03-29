package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.prize.Prize;
import lotto.domain.shop.LottoShop;
import lotto.domain.stats.LottoEarningRateCalculator;
import lotto.domain.stats.LottoScoreBoard;
import lotto.view.dto.LottoDto;
import lotto.view.dto.LottoScoringDto;
import lotto.view.dto.LottoScoringResultDto;
import lotto.view.dto.LottoWinnerDto;


public class LottoScoringService {

    public LottoScoringResultDto score(LottoScoringDto lottoScoringDto) {
        List<LottoWinnerDto> winnerDtoList = new ArrayList<>();
        LottoScoreBoard lottoScoreBoard = getRenewedScoreBoard(lottoScoringDto);

        for (Prize prize : Prize.values()) {
            long equalNumberCount = prize.getEqualNumberCount();
            long prizeAmount = prize.getPrizeAmount();

            winnerDtoList.add(new LottoWinnerDto(equalNumberCount, prizeAmount,
                    lottoScoreBoard.getWinningsByEqualNumberCount(equalNumberCount)));
        }
        String earningRate = calculateEarningRate(lottoScoringDto, lottoScoreBoard);
        return new LottoScoringResultDto(winnerDtoList, earningRate);
    }

    private LottoScoreBoard getRenewedScoreBoard(LottoScoringDto lottoScoringDto) {
        LottoScoreBoard lottoScoreBoard =
                new LottoScoreBoard(convertToWinnerLottoFromDto(lottoScoringDto),
                                    convertToLottoListFromDto(lottoScoringDto));
        lottoScoreBoard.scoring();
        return lottoScoreBoard;
    }

    private String calculateEarningRate(LottoScoringDto lottoScoringDto,
            LottoScoreBoard lottoScoreBoard) {
        long principal = lottoScoringDto.getLottoOrderedNumber().size() * LottoShop.LOTTO_PRICE;
        return new LottoEarningRateCalculator(principal, lottoScoreBoard).resultToString();
    }

    private List<Lotto> convertToLottoListFromDto(LottoScoringDto lottoScoringDto) {
        return lottoScoringDto.getLottoOrderedNumber().stream()
                .map(LottoDto::getNumbers)
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private Lotto convertToWinnerLottoFromDto(LottoScoringDto lottoScoringDto) {
        return new Lotto(lottoScoringDto.getLottoWinnerNumber());
    }
}
