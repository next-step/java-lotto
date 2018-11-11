package lotto.view.web.hadlebars.helper;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by hspark on 11/11/2018.
 */
public class LengthHelper implements Helper<Object> {
	public static final String HELPER_NAME = "length";

	@Override
	public CharSequence apply(Object context, Options options) throws IOException {
		int size = getSize(context);
		return String.valueOf(size);
	}

	private int getSize(Object context) {
		if (Objects.isNull(context)) {
			return 0;
		}
		if (context.getClass().isArray()) {
			return Array.getLength(context);
		}
		if (Collection.class.isAssignableFrom(context.getClass())) {
			Collection collection = Collection.class.cast(context);
			return collection.size();
		}
		throw new IllegalArgumentException();
	}
}
