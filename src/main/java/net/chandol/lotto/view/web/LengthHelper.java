package net.chandol.lotto.view.web;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.util.Collection;

public class LengthHelper implements Helper<Object> {

    @Override
    public Integer apply(final Object value, Options options) {
        if (value instanceof Object[]) {
            return ((Object[]) value).length;
        } else if (value instanceof Collection) {
            return ((Collection) value).size();
        } else {
            return 0;
        }
    }
}