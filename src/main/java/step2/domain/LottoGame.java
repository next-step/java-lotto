package step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGame {

    private List<Lotto> lottos;

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Integer> convertString2IntegerList(List<String> stringList) {
        List<Integer> result = new ArrayList<>();
        stringList.stream().forEach(string -> {
            result.add(Integer.parseInt(string));
        });
        return result;
    }

    private List<String> parseWinningNumbers(String winningNumbers) {
        String[] parsedWinningNumbers = winningNumbers.split(",");
        return Arrays.asList(parsedWinningNumbers);
    }

    public LottoGameResultDto getGameResult(List<Integer> winningNumbers) {
        drawLottos(winningNumbers);
        double earningRate = getEarningRate();
        int firstPrizeCount = (int) this.lottos.stream().filter(lotto -> lotto.getPrize() == 1)
            .count();
        int secondPrizeCount = (int) this.lottos.stream().filter(lotto -> lotto.getPrize() == 2)
            .count();
        int thirdPrizeCount = (int) this.lottos.stream().filter(lotto -> lotto.getPrize() == 3)
            .count();
        int forthPrizeCount = (int) this.lottos.stream().filter(lotto -> lotto.getPrize() == 4)
            .count();

        return new LottoGameResultDto(
            earningRate,
            firstPrizeCount,
            secondPrizeCount,
            thirdPrizeCount,
            forthPrizeCount);
    }

    private double getEarningRate() {
        int wonCount = (int) this.lottos.stream().filter(lotto -> lotto.getPrize() > 0).count();
        if (wonCount > 0) {
            return (double) wonCount / lottos.size();
        }

        return 0;
    }

    private void drawLottos(List<Integer> winningNumbers) {
        lottos.stream().forEach(lotto -> lotto.setPrize(winningNumbers));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
