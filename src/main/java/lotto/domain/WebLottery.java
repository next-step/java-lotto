package lotto.domain;

import lotto.dto.LotteriesDto;
import lotto.dto.LotteryQuantityDto;
import lotto.dto.MatchingLotteryDto;
import lotto.dto.ProfitDto;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import util.Random;

import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;

public class WebLottery {
    static final int LOTTERY_PRICE = 1000;
    static final int START_INDEX = 1;

    private TotalLotteries totalLotteries;

    public void getMoneyAndLotteries() {
        get("/index", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            return render(model, "/index.html");
        });
    }

    public void postLotteryInfo() {
        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            String manualNumber = req.queryParams("manualNumber");
            String inputMoney = req.queryParams("inputMoney");

            this.totalLotteries = new TotalLotteries(inputMoney);

            int totalQuantity = Integer.parseInt(inputMoney) / LOTTERY_PRICE;
            LotteryQuantityDto lotteryQuantityDto = new LotteryQuantityDto(totalQuantity);

            Lottery lottery = new Lottery();

            String [] manualNumbers = lottery.separateLottery(manualNumber);

            Lotteries lotteries = makeLottery(manualNumbers);

            int manualQuantity = manualNumbers.length;
            AutoLotteries autoLotteries = new AutoLotteries(totalQuantity, manualQuantity);

            Random random = new Random();
            this.totalLotteries.generateLotteries(lotteries, autoLotteries.generateAutoLotteries(random));

            String [] splitTotalLotteries = this.totalLotteries.toStringTotalLotteries().split("\n");

            List<LotteriesDto> lotteriesDtos = makeLotteriesDtos(splitTotalLotteries);

            model.put("totalQuantity", lotteryQuantityDto.getTotalQuantity());
            model.put("lotteries", lotteriesDtos);

            return render(model, "/show.html");
        });
    }

    private List<LotteriesDto> makeLotteriesDtos(String[] splitTotalLotteries) {
        List<LotteriesDto> lotteriesDtos = new ArrayList<>();
        int splitTotalLotteriesSize = splitTotalLotteries.length;
        for (int i = 0; i < splitTotalLotteriesSize; i++) {
            lotteriesDtos.add(new LotteriesDto(i + START_INDEX, splitTotalLotteries[i]));
        }

        return lotteriesDtos;
    }

    private Lotteries makeLottery(String[] manualNumbers) {
        Lotteries lotteries = new Lotteries();
        for (String number : manualNumbers) {
            Lottery lottery = new Lottery();
            lotteries.add(lottery.makeLotteryByInput(number));
        }
        return lotteries;
    }

    public void postShowResult() {
        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String winningNumber = req.queryParams("winningNumber");
            String bonusNumber = req.queryParams("bonusNumber");

            Lottery lottery = new Lottery();
            WinnerLottery winnerLottery = new WinnerLottery(lottery.makeLotteryByInput(winningNumber), Integer.parseInt(bonusNumber));

            Map<String, Integer> ranks = this.totalLotteries.makeAllLotteriesRank(winnerLottery);
            List<MatchingLotteryDto> matchingLotteryDtos = makeMatchingLotteryDtos(ranks);

            ProfitDto profitDto = new ProfitDto(this.totalLotteries.calculateProfit(winnerLottery));

            model.put("matchingLottery", matchingLotteryDtos);
            model.put("profit", profitDto.getProfit());

            return render(model, "/result.html");
        });
    }

    private List<MatchingLotteryDto> makeMatchingLotteryDtos(Map<String, Integer> ranks) {
        List<MatchingLotteryDto> matchingLotteryDtos = new ArrayList<>();

        matchingLotteryDtos.add(new MatchingLotteryDto("3", "5000", ranks.get("fifth")));
        matchingLotteryDtos.add(new MatchingLotteryDto("4", "50000", ranks.get("fourth")));
        matchingLotteryDtos.add(new MatchingLotteryDto("5", "150000", ranks.get("third")));
        matchingLotteryDtos.add(new MatchingLotteryDto("5", "3000000", ranks.get("second")));
        matchingLotteryDtos.add(new MatchingLotteryDto("6", "2000000000", ranks.get("first")));

        return matchingLotteryDtos;
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
