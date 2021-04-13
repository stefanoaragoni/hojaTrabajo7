import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class insertTest {

	@Test
	void test() {
		Key llave = new Key<String, Words>();
        Comparator compare = new Comparator<String, Words>();
		ArbolBinarioBusqueda treeEn = new ArbolBinarioBusqueda<String, Words>(compare, llave);
		
		Words en = new Words("english","cat", "gato", "catEnFrances");
		
		try {
			treeEn.Insert("english", en);
		}
		catch(Exception e) {
			fail("Not yet implemented");
		}
		
			
		
	}

}
