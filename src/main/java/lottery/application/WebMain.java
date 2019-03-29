package lottery.application;

import lottery.domain.*;
import spark.ModelAndView;
import spark.Session;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;
import java.util.regex.Pattern;

import static spark.Spark.*;
public class WebMain {
    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "index.html");
        });

        post("/buyLotto", (req, res) -> {
            Session session = req.session();
            Map<String, Object> model = new HashMap<>();

            int inputMoney = Integer.parseInt(req.queryParams("inputMoney"));
            String manualNumber[] = req.queryParams("manualNumber").split("\n");

            LotteryMachine lotteryMachine = new LotteryMachine();
            inputManualNumbers(manualNumber);
            List<Lottery> lotteries = lotteryMachine.purchaseLotteries(new Money(inputMoney, manualNumber.length), inputManualNumbers(manualNumber));

            session.attribute("lotteries", lotteries);
            model.put("purchaseCount", lotteries.size());
            model.put("lotteries", lotteries);
            return render(model, "show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Session session = req.session();

            String winningNumbers[] = req.queryParams("winningNumber").split(",");
            int bonusNumber = Integer.parseInt(req.queryParams("bonusNumber"));
            List<Lottery> lotteries = session.attribute("lotteries");

            LotteryNumber winningNumber = new LotteryNumber(convertInts(winningNumbers), bonusNumber);
            LotteryResult lotteryResult = new LotteryMachine().checkWinning(lotteries, new Lottery(winningNumber));

            lotteryResult.getResultDatas().remove(RANK.MISS);
            model.put("resultDatas", lotteryResult.getResultDatas().entrySet());
            model.put("earningRates", lotteryResult.getEarningRates());
            return render(model, "result.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    public static List<List<Integer>> inputManualNumbers(String[] manualNumber) {
        List<List<Integer>> manualNumbers = new ArrayList<>(manualNumber.length);
        for (int index = 0; index < manualNumber.length; index++) {
            manualNumbers.add(convertInts(manualNumber[index].split(",")));
        }
        return manualNumbers;
    }

    private static List<Integer> convertInts(String[] values) {
        List<Integer> numbers = new ArrayList<>();
        for (int index = 0; index < values.length ; index++) {
            String value = values[index];
            value = getString(value);
            numbers.add(Integer.parseInt(value));
        }
        return numbers;
    }

    private static String getString(String value) {
        if(!isNumber(value)) { // 맨 마지막이나 그럴 때 인식을 못해줘서 추가함
            value = value.replaceAll("[^0-9]", "");
        }
        return value;
    }

    private static boolean isNumber(String value) {
        return Pattern.matches("[0-9]+", value);
    }
}