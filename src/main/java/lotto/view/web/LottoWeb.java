package lotto.view.web;

import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.ManualPickInfo;
import lotto.domain.ManualPickLottoGenerator;
import lotto.domain.Money;
import lotto.domain.QuickPickLottoGenerator;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.dto.PurchaseInfo;
import lotto.dto.WinningNumber;
import lotto.utils.StringUtils;
import lotto.utils.WinningLottoGenerator;
import spark.ModelAndView;
import spark.Session;

public class LottoWeb {

	private static final LottoMachine manualPickLottoMachine = new LottoMachine(new ManualPickLottoGenerator());
	private static final LottoMachine quickPickLottoMachine = new LottoMachine(new QuickPickLottoGenerator());

	public static void main(String[] args) {
		port(8080);

		get("/", (req, res) -> render(null, "index.html"));

		post("/buyLotto", (req, res) -> {
			Money money = new Money(Integer.valueOf(req.queryParams("inputMoney")));
			ManualPickInfo manualPickInfo = new ManualPickInfo(parseManualNumbers(req.queryParams("manualNumber")));
			PurchaseInfo purchaseInfo = new PurchaseInfo(money, manualPickInfo);
			LottoTicket lottoTicket = LottoTicket.of(
					manualPickLottoMachine.purchase(purchaseInfo), quickPickLottoMachine.purchase(purchaseInfo)
			);

			Session session = req.session();
			session.attribute("purchaseInfo", purchaseInfo);
			session.attribute("lottoTicket", lottoTicket);

			Map<String, Object> model = new HashMap<>();
			model.put("totalCount", purchaseInfo.getMoney().getTotalPickCount());
			model.put("lottos", lottoTicket.getLottos());
			return render(model, "show.html");
		});

		post("/matchLotto", (req, res) -> {
			Session session = req.session();
			PurchaseInfo purchaseInfo = session.attribute("purchaseInfo");
			LottoTicket lottoTicket = session.attribute("lottoTicket");

			WinningNumber winningNumber = new WinningNumber(
					req.queryParams("winningNumber"), LottoNumber.valueOf(req.queryParams("bonusNumber")));
			WinningLotto winningLotto = WinningLottoGenerator.generate(winningNumber);

			WinningResult winningResult = lottoTicket.match(winningLotto);
			double profitRate = purchaseInfo.getMoney().calculateProfitRate(winningResult.getTotalPrizeMoney());

			Map<String, Object> model = new HashMap<>();
			model.put("winningResult", winningResult);
			model.put("profitRate", profitRate);
			return render(model, "result.html");
		});

		exception(Exception.class, (exception, req, res) -> res.redirect("/"));
	}

	private static List<String> parseManualNumbers(String manualNumber) {
		if(StringUtils.isBlank(manualNumber)) {
			return Collections.emptyList();
		}
		return Arrays.stream(manualNumber.split("\n"))
						.collect(Collectors.toList());
	}

	public static String render(Map<String, Object> model, String templatePath) {
		return new CustomHandlebarsTemplateEngine()
				.render(new ModelAndView(model, templatePath));
	}
}
