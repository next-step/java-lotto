package lotto.web;

import lotto.domain.Lotto;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebOutputView {
    public String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    public List<String> lottosToStringList(List<Lotto> lottos) {
        List<String> toStrings = new ArrayList<>();

        for (Lotto lotto : lottos) {
            toStrings.add(lotto.toString());
        }

        return toStrings;
    }

    public String calculateProfit(double profit) {
        return profit * 100 + "%";
    }
}
