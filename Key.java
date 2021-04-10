

/**
 * @author moise
 *
 */
public class Key<K, T> implements IKeyCalculator<K, T> {

	@Override
	public K GetKey(T value) {
		Words actual = (Words)value;
		return (K)actual.ID();
	}

}
