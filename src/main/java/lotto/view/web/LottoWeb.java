package lotto.view.web;

import lotto.domain.*;
import lotto.domain.common.Money;
import lotto.domain.generator.LottoTicketDispenser;
import lotto.domain.generator.PurchaseLottoTicketRequestInfo;
import lotto.domain.generator.PurchaseLottoTicketResultInfo;
import lotto.domain.generator.ShuffleLottoTicketDispenser;
import lotto.view.web.hadlebars.helper.LengthHelper;
import org.apache.commons.lang3.StringUtils;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;
import java.util.stream.Collectors;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

/**
 * Created by hspark on 11/11/2018.
 */
public class LottoWeb {
	private static final LottoTicketDispenser lottoTicketDispenser = new ShuffleLottoTicketDispenser(new ShuffleLottoMachine());

	public static void main(String[] args) {
		port(8080);
		routes();
	}

	private static void routes() {
		get("/", (req, res) -> render(new HashMap<>(), "/index.html"));
		post("/buyLotto", LottoWeb::buyLotto);
		post("/matchLotto", LottoWeb::matchLotto);
	}

	private static Object buyLotto(Request request, Response response) {
		String manualLottoNumberInput = request.queryParams("manualNumber");
		Long inputMoney = Long.parseLong(request.queryParams("inputMoney"));

		List<LottoTicket> manualLottoTickets = createLottoTickets(manualLottoNumberInput);
		Money purchaseMoney = Money.of(inputMoney);

		PurchaseLottoTicketRequestInfo requestInfo = new PurchaseLottoTicketRequestInfo(purchaseMoney, manualLottoTickets);
		PurchaseLottoTicketResultInfo resultInfo = lottoTicketDispenser.purchase(requestInfo);

		request.session().attribute("ticketInfo", resultInfo);
		Map<String, Object> model = new HashMap<>();
		model.put("ticketInfo", resultInfo);
		return render(model, "/show.html");
	}

	private static Object matchLotto(Request request, Response response) {
		List<LottoNumber> winningNumbers = createLottoNumbers(request.queryParams("winningNumber"));
		LottoNumber bonusNumberInput = LottoNumber.of(Integer.parseInt(request.queryParams("bonusNumber")));

		WinningLottoTicket winningLottoTicket = new WinningLottoTicket(winningNumbers, bonusNumberInput);
		PurchaseLottoTicketResultInfo purchaseLottoTicketResultInfo = request.session().attribute("ticketInfo");

		Lotto lotto = new Lotto(purchaseLottoTicketResultInfo.getTickets());
		LottoMatchingResult result = lotto.matchNumber(winningLottoTicket);

		Map<String, Object> model = new HashMap<>();
		model.put("matchResult", result);
		return render(model, "/result.html");
	}

	private static List<LottoTicket> createLottoTickets(String manualLottoNumberInput) {
		List<LottoTicket> manualLottoTickets = new ArrayList<>();
		if (StringUtils.isEmpty(manualLottoNumberInput)) {
			return manualLottoTickets;
		}
		for (String manualLottoNumber : manualLottoNumberInput.split("\r\n")) {
			List<LottoNumber> lottoNumbers = createLottoNumbers(manualLottoNumber);
			manualLottoTickets.add(LottoTicket.newInstanceByManual(lottoNumbers));
		}
		return manualLottoTickets;
	}

	private static List<LottoNumber> createLottoNumbers(String manualLottoNumber) {
		return Arrays.stream(manualLottoNumber.split(",")).peek(String::trim)
			.map(Integer::parseInt).map(LottoNumber::of).collect(Collectors.toList());
	}

	public static String render(Map<String, Object> model, String templatePath) {
		return new CustomHandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
	}

	private static class CustomHandlebarsTemplateEngine extends HandlebarsTemplateEngine {
		public CustomHandlebarsTemplateEngine() {
			handlebars.registerHelper(LengthHelper.HELPER_NAME, new LengthHelper());
		}
	}
}
