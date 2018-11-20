package lotto.view.web;

import com.github.jknack.handlebars.Helper;
import lotto.domain.LottoResultDefault;
import lotto.domain.Rank;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class CustomHandlebarsTemplateEngine extends HandlebarsTemplateEngine {

    public CustomHandlebarsTemplateEngine() {
        super();
        handlebars.registerHelper("idx", (Helper<Integer>) (value, option) -> value + 1);
        handlebars.registerHelpers(this);
    }

    public String makeResultString(LottoResultDefault result) {
        StringBuffer sb = new StringBuffer();
        Rank[] value = Rank.values();
        String view;
        for(int i = value.length - 1; i >= 0; i--) {
            if(value[i] == Rank.MISS) continue;

            view = "%d개 일치 (%d원) - %d개";
            if(value[i] == Rank.SECOND) {
                view = "%d개 일치, 보너스 볼 일치(%d원)- %d개";
            }

            sb.append("<tr>")
                    .append("<th>")
                    .append(String.format(view, value[i].getCountOfMatch(), value[i].getWinningMoney(), result.getRankingCount(value[i])))
                    .append("</th>")
                    .append("</tr>");
        }
        return sb.toString();
    }
}
