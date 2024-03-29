/**
 * @author moises alonso
 *
 */
public class ArbolBinarioBusqueda<K, T> implements IArbolBinario<K, T> {

	public Association<K, T> _raiz;
	int _count;
	IComparator<K, T> _keyComparator;
	IKeyCalculator<K, T> _keyCalculator;
	
	public ArbolBinarioBusqueda(IComparator<K, T> metodoComparar, IKeyCalculator<K, T> metodoCalcularLlave) {
		_keyComparator = metodoComparar;
		_keyCalculator = metodoCalcularLlave;
		_raiz = null;
		_count = 0;
	}
	
	@Override
	public void Insert(K key, T value) {
		Association<K, T> _new = new Association<K, T>(key, value);

		if (_raiz == null) {
			_raiz = _new;
			_count++;
		} else {
			try {
				InsertAux(_raiz, _new);
			} catch(Exception e) {
				//Manejo de exception
			}
			
		}
	}
	
	private void InsertAux(Association<K, T> _actual, Association<K, T> _new) throws Exception{
		if (_actual != null) {
			
			if (_keyComparator.Compare(_actual._key, _new._key) > 0) { //Entra cuando actual > nuevo Inserta en hijo izquierdo
				if (_actual.hijoIzquierdo == null) { //Puedo insertar en hijo izquierdo
					_actual.hijoIzquierdo = _new;
					_count++;
				} else { //Entra cuando no puedo insertar en el hijo izquierdo de actual ya que est� ocupado
					InsertAux(_actual.hijoIzquierdo, _new);
				}
			} else if (_keyComparator.Compare(_actual._key, _new._key) < 0) { //Entra cuando actual < nuevo Inserta en hijo derecho
			
				if (_actual.hijoDerecho == null) { //Puedo insertar en hijo derecho
					_actual.hijoDerecho = _new;
					_count++;
				} else { //Entra cuando no puedo insertar en el hijo derecho de actual ya que est� ocupado
					InsertAux(_actual.hijoDerecho, _new);
				}
			} else {
				throw new Exception("Llaves repetidas");
			}
			
		}
	}

	@Override
	public T Delete(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T Find(K key) {
		return null;
	}

	public T Find2(K key, Association<K, T> actual) {
		
		T temp = null;

		if (actual != null) {

			if((actual._key).equals(key)){
				temp = actual._value;
			}

			if(temp == (null)){
				temp = Find2(key, actual.hijoIzquierdo);
			}
			if(temp == (null)){
				temp = Find2(key, actual.hijoDerecho);
			}
			
		}

		return temp;
	}

	@Override
	public int Count() {
		return _count;
	}

	@Override
	public boolean IsEmpty() {
		return _count == 0;
	}

	@Override
	public void InOrder(IVisitar<K, T> visitNode, Association<K, T> actual) {
		if (actual != null) {
			InOrder(visitNode, actual.hijoIzquierdo);
			
			visitNode.VisitarNodo(actual);
			
			InOrder(visitNode, actual.hijoDerecho);
		}
		
	}

	@Override
	public void PreOrder(IVisitar<K, T> visitNode, Association<K, T> actual) {
		if (actual != null) {
			visitNode.VisitarNodo(actual);
			
			PreOrder(visitNode, actual.hijoIzquierdo);
			
			PreOrder(visitNode, actual.hijoDerecho);
		}
		
	}

	@Override
	public void PostOrder(IVisitar<K, T> visitNode, Association<K, T> actual) {
		if (actual != null) {
			
			PostOrder(visitNode, actual.hijoIzquierdo);
			
			PostOrder(visitNode, actual.hijoDerecho);
			
			visitNode.VisitarNodo(actual);
		}
		
	}

}
