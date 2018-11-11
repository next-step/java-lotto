package lotto.view.web;

import com.github.jknack.handlebars.Handlebars.SafeString;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import java.io.IOException;
import lotto.domain.WinningResult;
import lotto.enums.Prize;

public class ResultHelper implements Helper<WinningResult> {

	@Override
	public Object apply(WinningResult winningResult, Options options) throws IOException {
		StringBuilder result = new StringBuilder();
		Prize[] prizes = Prize.values();
		for (int index = prizes.length - 1; index >= 0; index--) {
			Prize prize = prizes[index];
			if(prize.equals(Prize.NO_MATCH)) {
				continue;
			}

			String output = "%d개 일치 (%d원) - %d개";
			if(prize.equals(Prize.SECOND)) {
				output = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
			}
			result
					.append("<tr>")
					.append("<th>")
					.append(String.format(output,
							prize.getMatchCount(), prize.getMoney(), winningResult.getPrizeCount(prize)))
					.append("</th>")
					.append("</tr>");
		}
		return new SafeString(result.toString());
	}
}
