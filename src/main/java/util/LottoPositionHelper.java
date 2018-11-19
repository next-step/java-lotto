package util;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;

public class LottoPositionHelper implements Helper<Integer> {
    public static final String NAME = "position";

    @Override
    public Object apply(Integer context, Options options) throws IOException {
        return context + 1;
    }
}
