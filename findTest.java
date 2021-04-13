import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class findTest {

	@Test
	void test() {
		Key llave = new Key<String, Words>();
        Comparator compare = new Comparator<String, Words>();
		ArbolBinarioBusqueda treeEn = new ArbolBinarioBusqueda<String, Words>(compare, llave);
		
		Words en = new Words("english","cat", "gato", "catEnFrances");
		String spanish = "";
		
		treeEn.Insert("cat", en);
		
		Words temp = (Words)treeEn.Find2("cat", treeEn._raiz);
		
			
			
		spanish = temp.spanish;
		assertEquals("gato",spanish);
		
		
		
	}

}
