package lotto.ui.handlebars.helper;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import lotto.enums.LottoReword;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public class MapGetHelper implements Helper<HashMap<Object, Object>> {

    @Override
    public Object apply(HashMap<Object, Object> context, Options options) throws IOException {
        return context.get(options.context.model());
    }
}
