import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TDDPigLatinTest {

	@Test
	void testStartingVowels() {
		assertEquals("appleway", TDDPigLatin.translate("apple"));
		assertEquals("essieway", TDDPigLatin.translate("essie"));
		assertEquals("iconway", TDDPigLatin.translate("icon"));
		assertEquals("octagonway", TDDPigLatin.translate("octagon"));
		assertEquals("unityway", TDDPigLatin.translate("unity"));
	}
	
	@Test
	void testCaps() {
		assertEquals("appleway", TDDPigLatin.translate("Apple"));
		assertEquals("essieway", TDDPigLatin.translate("Essie"));
		assertEquals("iconway", TDDPigLatin.translate("Icon"));
		assertEquals("octagonway", TDDPigLatin.translate("Octagon"));
		assertEquals("unityway", TDDPigLatin.translate("Unity"));
	}
	
	@Test
	void testOneConsonant() {
		assertEquals("onebay", TDDPigLatin.translate("bone"));
		assertEquals("optay", TDDPigLatin.translate("top"));
		assertEquals("oobay", TDDPigLatin.translate("boo"));
		assertEquals("ubsay", TDDPigLatin.translate("sub")); //Not subway!
	}
	
	@Test
	void testTwoConsonants() {
		assertEquals("endanbray", TDDPigLatin.translate("brendan"));
		assertEquals("andonbray", TDDPigLatin.translate("brandon"));
		assertEquals("aggeddray", TDDPigLatin.translate("dragged"));
		assertEquals("occurredway", TDDPigLatin.translate("occurred"));
	}
	
	@Test
	void testMoreConsonants() {
		assertEquals("oechlay", TDDPigLatin.translate("chloe"));
		assertEquals("udelstray", TDDPigLatin.translate("strudel"));
		assertEquals("engthsstray", TDDPigLatin.translate("strengths"));
		assertEquals("udelstray", TDDPigLatin.translate("strudel"));
	}

}
