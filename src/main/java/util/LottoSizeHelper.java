package util;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;
import java.util.Collection;

public class LottoSizeHelper implements Helper<Collection<Object>> {
    public static final String NAME = "size";

    @Override
    public Object apply(Collection<Object> context, Options options) throws IOException {
        return context.size();
    }
}
