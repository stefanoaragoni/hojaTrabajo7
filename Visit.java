
/**
 * @author moise
 *
 */
public class Visit<K, T> implements IVisitar<K, T> {

	@Override
	public void VisitarNodo(Association<K, T> arbol) {
		Words actual = (Words)arbol._value;
		actual.printWords();
	}
	
}
