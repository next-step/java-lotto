package lotto.view.web.controller;

import java.util.Map;

public interface LottoWebController {
    String render(Map<String, Object> model, String templatePath);
}
