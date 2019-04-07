package lotto.view;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.MyLottos;
import lotto.domain.WinNumbers;
import lotto.domain.WinStats;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class WebView {

  public static void main(String[] args) {

    port(8080);
    Map<String, Object> model = new HashMap<>();

    get("/", (request, response) -> render(new HashMap<>(), "/index.html"));

    post("/buyLotto", (request, response) -> {

      String inputMoney = request.queryParams("inputMoney");
      String manualNumber = request.queryParams("manualNumber");

      MyLottos myLottos = buyLottos(inputMoney, manualNumber);
      model.put("myLottos", myLottos);
      return render(model, "/show.html");
    });

    post("/matchLotto", (request, response) -> {

      String winningNumber = request.queryParams("winningNumber");
      String bonusNumber = request.queryParams("bonusNumber");

      WinNumbers winNumbers = WinNumbers.of(winningNumber, Integer.parseInt(bonusNumber));

      MyLottos myLottos = (MyLottos)model.get("myLottos");
      WinStats winStats = myLottos.winStats(winNumbers);

      model.put("winStats", winStats);
      return render(model, "/result.html");
    });
  }

  private static MyLottos buyLottos(String inputMoney, String manualNumber) {

    Money buyMoney = new Money(Integer.parseInt(inputMoney));
    int buyQuantity = LottoStore.quantity(buyMoney);

    List<String> manualNumbers = Arrays.asList(manualNumber.split("\n"));
    Lottos lottos = LottoStore.buy(buyQuantity, manualNumbers);

    return new MyLottos(buyMoney, lottos);
  }

  private static String render(Map<String, Object> model, String templatePath) {
    return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
  }
}
