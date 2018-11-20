package lotto.config;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;

public class Incremented implements Helper<Integer> {

    @Override
    public Object apply(Integer context, final Options options) throws IOException {
        return context + 1;
    }
}
