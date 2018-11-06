package lotto.domain.validator;

/**
 * Created by hspark on 07/11/2018.
 */
public interface Validator<T> {
	void valid(T t);
}
