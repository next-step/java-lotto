package lotto.ui.handlebars.helper;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class CollectionLengthHelper implements Helper<Collection<Object>> {

    @Override
    public Object apply(Collection<Object> context, Options options) throws IOException {
        return context.size();
    }
}
