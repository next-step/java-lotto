package lotto;

import lotto.config.CustomHandlebarsTemplateEngineConfiguration;
import lotto.domain.*;
import lotto.utils.AutomaticallyLottosGenerator;
import spark.ModelAndView;

import java.util.*;

import static spark.Spark.*;

public class WebMain {

    public static void main(String[] args) {

        port(8080);

        get("/", (request, response1) -> render(new HashMap<>(), "/index.html"));

        post("/buyLotto", (request, response) -> {

            final String amount = request.queryParams("inputMoney");
            final String manualNumber = request.queryParams("manualNumber");

            final Lottos lottos = new Lottos();
            String[] manualNumbers = new String[]{};

            if (!"".equals(manualNumber) && manualNumber != null) {
                manualNumbers = manualNumber.split("\r\n");
                manualLottoPurchase(lottos, manualNumbers);
            }

            final Money money = new Money(Integer.parseInt(amount), hasManualNumbers(manualNumbers) ? manualNumbers.length + 1 : 0);

            request.session().attribute("lottoGame", new LottoGame(money, new AutomaticallyLottosGenerator(), lottos));
            request.session().attribute("money", money);

            final Map<String, Object> model = new HashMap<>();
            model.put("lottos", lottos.getLottos());
            model.put("lottosCount", lottos.getLottos().size());
            return render(model, "/show.html");
        });

        post("/matchLotto", (request, response) -> {

            final String winningNumber = request.queryParams("winningNumber");
            final String bonusNumber = request.queryParams("bonusNumber");

            final LottoGame lottoGame = request.session().attribute("lottoGame");
            final Money money = request.session().attribute("money");
            final LottoDto lottoDto = new LottoDto(lottoGame, new WinningLotto(new Lotto(winningNumber), Integer.parseInt(bonusNumber)));

            final Map<String, Object> model = new HashMap<>();
            model.put("results", new ArrayList<>(appendRanks(lottoDto)));
            model.put("totalRate", addTotalRate(lottoDto, money));
            return render(model, "/result.html");
        });
    }

    public static String render(final Map<String, Object> model, final String templatePath) {
        return new CustomHandlebarsTemplateEngineConfiguration().render(new ModelAndView(model, templatePath));
    }

    private static boolean hasManualNumbers(final String[] manualNumbers) {
        return manualNumbers.length > 0;
    }

    private static void manualLottoPurchase(final Lottos lottos, final String[] manualNumbers) {
        for (final String manualNum : manualNumbers) {
            lottos.add(new Lotto(manualNum));
        }
    }

    private static List<String> appendRanks(final LottoDto lottoDto) {
        final Map<Rank, Lottos> rankLottos = LottoResult.calculateLottoResult(lottoDto);
        return Arrays.asList(
                appendRank(Rank.FIFTH, rankLottos.get(Rank.FIFTH)),
                appendRank(Rank.FOURTH, rankLottos.get(Rank.FOURTH)),
                appendRank(Rank.THIRD, rankLottos.get(Rank.THIRD)),
                appendRank(Rank.SECOND, rankLottos.get(Rank.SECOND)),
                appendRank(Rank.FIRST, rankLottos.get(Rank.FIRST))
        );
    }

    @SuppressWarnings({"Duplicates", "StringBufferReplaceableByString"})
    private static String appendRank(final Rank rank, final Lottos lottos) {
        final StringBuilder sb = new StringBuilder();
        sb.append(rank.getCountOfMatch());
        sb.append(rank.equals(Rank.SECOND) ? "개 일치, 보너스 볼 일치(" : "개 일치 (");
        sb.append(rank.getWinningMoney());
        sb.append(")- ");
        sb.append(Lottos.rankOfMatchSize(lottos));
        sb.append("개\n");
        return sb.toString();
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    private static String addTotalRate(final LottoDto lottoDto, final Money money) {
        final StringBuilder sb = new StringBuilder();
        sb.append("총 수익률은 ");
        sb.append(money.calculateRate(lottoDto));
        sb.append("%입니다.");
        return sb.toString();
    }

}
