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

public class LottoScoring {

    public LottoScoringResultDto score(LottoScoringDto lottoScoringDto) {
        LottoScoreBoard lottoScoreBoard = getRenewedScoreBoard(lottoScoringDto);

        String earningRate = calculateEarningRate(lottoScoringDto, lottoScoreBoard);
        List<LottoWinnerDto> winnerDtoList = getWinnerDtoFromBoard(lottoScoreBoard);
        return new LottoScoringResultDto(winnerDtoList, earningRate);
    }

    private LottoScoreBoard getRenewedScoreBoard(LottoScoringDto lottoScoringDto) {
        LottoScoreBoard lottoScoreBoard =
                new LottoScoreBoard(lottoScoringDto.getWinnerLottoDto(),
                                    convertFromDtoToLottoList(lottoScoringDto));
        lottoScoreBoard.scoring();
        return lottoScoreBoard;
    }

    private String calculateEarningRate(LottoScoringDto lottoScoringDto,
            LottoScoreBoard lottoScoreBoard) {
        long principal = lottoScoringDto.getLottoOrderedNumber().size() * LottoShop.LOTTO_PRICE;
        return new LottoEarningRateCalculator(principal, lottoScoreBoard).resultToString();
    }

    private List<LottoWinnerDto> getWinnerDtoFromBoard(LottoScoreBoard lottoScoreBoard) {
        List<LottoWinnerDto> winnerDtoList = new ArrayList<>();

        for (Prize prize : Prize.values()) {
            long equalNumberCount = prize.getEqualNumberCount();
            long prizeAmount = prize.getPrizeAmount();

            winnerDtoList.add(new LottoWinnerDto(equalNumberCount, prizeAmount,
                    lottoScoreBoard.getWinningsByPrize(Prize.getPrizeByEqualNumberCount(equalNumberCount))));
        }
        return winnerDtoList;
    }

    private List<Lotto> convertFromDtoToLottoList(LottoScoringDto lottoScoringDto) {
        return lottoScoringDto.getLottoOrderedNumber()
                .stream()
                .map(LottoDto::getNumbers)
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private Lotto convertFromDtoToWinnerLotto(LottoScoringDto lottoScoringDto) {
        return new Lotto(lottoScoringDto.getLottoWinnerNumber());
    }
}
