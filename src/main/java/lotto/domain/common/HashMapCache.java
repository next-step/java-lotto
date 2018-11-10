package lotto.domain.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hspark on 10/11/2018.
 */
public class HashMapCache<K, V> implements Cache<K, V> {

	private final Map<K, V> CACHE = new HashMap<>();

	@Override
	public void put(K key, V value) {
		CACHE.put(key, value);
	}

	@Override
	public V get(K key) {
		return CACHE.get(key);
	}
}
