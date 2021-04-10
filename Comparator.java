
public class Comparator<K, T> implements IComparator<K, T> {

	public int Compare(K abb1, K abb2) {
		String placa1 = (String)abb1;
		String placa2 = (String)abb2;
		return placa1.compareTo(placa2);
	}

}
