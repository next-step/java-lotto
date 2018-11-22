package lotto;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.config.AutoLottoGeneratorImpl;
import lotto.config.ManualLottoGeneratorImpl;
import lotto.dto.Money;
import lotto.dto.Rank;
import lotto.dto.WinningLotto;
import lotto.service.LottoGame;
import lotto.service.LottoResult;
import lotto.utils.LottoMaker;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

    public class WebMain {
        public static void main(String[] args) {
            staticFiles.location("/templates");
            port(8080);

            get("/", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                model.put("name", "2cycle");
                return render(model, "/index.html");
            });


            post("/buyLotto", (req, res) -> {
                String inputMoney = req.queryParams("inputMoney");
                String ManualNums = req.queryParams("manualNumber");
                Money money = new Money(Integer.parseInt(inputMoney));
                LottoGame allGames = new LottoGame(new LottoGame(money , new AutoLottoGeneratorImpl()).getGamePlays()
                        ,new LottoGame(money,new ManualLottoGeneratorImpl(ManualNums)).getGamePlays());

                req.session().attribute("allGames" ,allGames);
                req.session().attribute("money" ,money);

                Map<String,Object> model = new HashMap<>();
                model.put("gameCount",allGames.getGames());
                model.put("games", allGames.stringOf());
                return render(model, "/show.html");
            });

            post("/matchLotto",(req, res) -> {
                LottoGame allGames = req.session().attribute("allGames");
                Money money = req.session().attribute("money");
                String winningNumber = req.queryParams("winningNumber");
                String bonusNumber = req.queryParams("bonusNumber");

                Map<Rank,Integer> maps = allGames.match(new WinningLotto(LottoMaker.of(winningNumber),Integer.parseInt(bonusNumber)));
                LottoResult lottoResult = new LottoResult(money.getMoney() , maps);

                Map<String,Object> model = new HashMap<>();
                model.put("matchResult",eachLottoResult(maps));
                model.put("lottoResult",(int)lottoResult.profit() * 100);
                return render(model, "/result.html");
            });

        }

        public static List<String> eachLottoResult(Map<Rank,Integer> resultMaps){
            List<String> printResult = new ArrayList<>();


            for(Rank rank : Rank.values()){
                if(rank == Rank.MISS) continue;

                StringBuilder sb = new StringBuilder();
                sb.append(rank.getMatch()).append("개 일치");
                if(rank == Rank.SECOND)
                    sb.append(", 보너스 볼 일치");
                sb.append(" (").append(rank.getWon()).append(") - ");
                sb.append(resultMaps.get(rank)).append("개\n");

                printResult.add(sb.toString());
            }
            return printResult;

        }

        public static String render(Map<String, Object> model, String templatePath) {
            return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
        }
    }

