package lotto.domain;

import java.util.List;

public class LottoGameResult {

    private static final int THREE_MATCH_MONEY = 5000;
    private static final int FOUR_MATCH_MONEY = 50000;
    private static final int FIVE_MATCH_MONEY = 1500000;
    private static final int SIX_MATCH_MONEY = 2000000000;

    public LottoDto getLottoResultForThree(List<Lotto> lottos, List<Integer> winningNumbers) {
        int result = 0;

        for (Lotto lotto : lottos) {
            int count = 0;
            count = getCount(winningNumbers, lotto, count);
            result = getResult(result, count, 3);
        }

        LottoDto lottoDto = makeLottoDto(result, THREE_MATCH_MONEY, 3);

        return lottoDto;
    }

    public LottoDto getLottoResultForFour(List<Lotto> lottos, List<Integer> winningNumbers) {
        int result = 0;

        for (Lotto lotto : lottos) {
            int count = 0;
            count = getCount(winningNumbers, lotto, count);
            result = getResult(result, count, 4);
        }

        LottoDto lottoDto = makeLottoDto(result, FOUR_MATCH_MONEY, 4);

        return lottoDto;
    }

    public LottoDto getLottoResultForFive(List<Lotto> lottos, List<Integer> winningNumbers) {
        int result = 0;

        for (Lotto lotto : lottos) {
            int count = 0;
            count = getCount(winningNumbers, lotto, count);
            result = getResult(result, count, 5);
        }

        LottoDto lottoDto = makeLottoDto(result, FIVE_MATCH_MONEY, 5);

        return lottoDto;
    }

    public LottoDto getLottoResultForSix(List<Lotto> lottos, List<Integer> winningNumbers) {
        int result = 0;

        for (Lotto lotto : lottos) {
            int count = 0;
            count = getCount(winningNumbers, lotto, count);
            result = getResult(result, count, 6);
        }

        LottoDto lottoDto = makeLottoDto(result, SIX_MATCH_MONEY, 6);

        return lottoDto;
    }

    private LottoDto makeLottoDto(int result, int winningMoney, int winnerCategory) {
        LottoDto lottoDto = new LottoDto();
        lottoDto.setWinnerCategory(winnerCategory);
        lottoDto.setMatchNumber(result);
        lottoDto.setWinningMoney(result * winningMoney);
        return lottoDto;
    }

    private int getResult(int result, int count, int matchNum) {
        if (count == matchNum) {
            result++;
        }
        return result;
    }

    private int getCount(List<Integer> winningNumbers, Lotto lotto, int count) {
        for (Integer numbers : winningNumbers) {
            count = getMatchNumberCount(lotto, count, numbers);
        }
        return count;
    }

    private int getMatchNumberCount(Lotto lotto, int count, Integer numbers) {
        if (lotto.getLottoNumbers().contains(numbers)) {
            count++;
        }
        return count;
    }


    public String getRatio(List<LottoDto> lottoDtos, int budget) {
        double totalMoney = 0;
        for (LottoDto lottoDto : lottoDtos) {
            totalMoney += lottoDto.getWinningMoney();
        }
        double result = totalMoney/(double)budget;

        return String.format("%.2f", result);
    }
}
