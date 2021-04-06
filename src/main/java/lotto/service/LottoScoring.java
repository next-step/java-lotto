package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBall;
import lotto.domain.lotto.LottoOrderedList;
import lotto.domain.prize.Prize;
import lotto.domain.shop.LottoShop;
import lotto.domain.stats.LottoScoreBoard;
import lotto.domain.stats.WinningLotto;
import lotto.dto.LottoOrderResultDto;
import lotto.dto.LottoOrderedDto;
import lotto.dto.LottoScoreDto;
import lotto.dto.LottoScoreResultDto;


public class LottoScoring {
    private final LottoScoreBoard lottoScoreBoard;

    public LottoScoring(LottoOrderResultDto lottoOrderResultDto,
                        List<Integer> numberList,
                        Integer bonusNumber) {
        this.lottoScoreBoard = new LottoScoreBoard(
                convertFromDtoToLottoOrderedList(lottoOrderResultDto),
                new WinningLotto(convertFromNumberListToLotto(numberList), new LottoBall(bonusNumber))
        );
    }

    public LottoScoreResultDto getResult() {
        List<LottoScoreDto> lottoScoreDtoList = new ArrayList<>();

        for (Prize prize : Prize.values()) {
            lottoScoreDtoList.add(new LottoScoreDto(
                    prize.getScore(),
                    prize.getMatchingBallCount(),
                    prize.getPrizeAmount(),
                    lottoScoreBoard.getWinnerCountByPrize(prize)));
        }
        return new LottoScoreResultDto(lottoScoreDtoList);
    }

    public String getEarningRate() {
        return lottoScoreBoard.getEarningRate();
    }

    private LottoOrderedList convertFromDtoToLottoOrderedList(LottoOrderResultDto lottoOrderResultDto) {
        return new LottoOrderedList(lottoOrderResultDto.getOrderResult().stream()
                .map(LottoOrderedDto::getLottoNumbers)
                .map(this::convertFromNumberListToLotto)
                .collect(Collectors.toList()));
    }

    private Lotto convertFromNumberListToLotto(List<Integer> numberList) {
        List<LottoBall> balls = numberList.stream()
                .map(LottoBall::new)
                .collect(Collectors.toList());
        return new Lotto(balls);
    }

}
