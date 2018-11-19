package lotto.ui.handlebars.helper;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;
import java.util.Collection;

public class IncrementsHelper implements Helper<Integer> {

    @Override
    public Object apply(Integer context, Options options) throws IOException {
        return context + 1;
    }
}
