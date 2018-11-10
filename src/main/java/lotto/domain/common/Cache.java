package lotto.domain.common;

/**
 * Created by hspark on 10/11/2018.
 */
public interface Cache<K, V> {
	void put(K key, V value);

	V get(K key);
}
