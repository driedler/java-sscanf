package util.sscanf;

public class SscanfTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Object variables[] = Sscanf.scan("123a 45bc", "123%02c 45%c%.25c678", '1', '2', '3');
		
		System.out.println("parse count: " + variables.length);
		System.out.println("char1: " + (char)variables[0]);
		System.out.println("char2: " + (char)variables[1]);
		System.out.println("char3: " + (char)variables[2]);
		
		variables = Sscanf.scan("This is only,attest", "%s %s,%04s", "1", "2", "3");
		
		System.out.println("parse count: " + variables.length);
		System.out.println("str1: " + (String)variables[0]);
		System.out.println("str2: " + (String)variables[1]);
		System.out.println("str3: " + (String)variables[2]);
		
		
		variables = Sscanf.scan("BSJB: 00DE 00AD#", "BSJB: %X %04X%s", 1, 2, "s");
		
		System.out.println("parse count: " + variables.length);
		System.out.println("cmd: " + (Long)variables[0]);
		System.out.println("cmd: " + (Long)variables[1]);
		System.out.println("str3: " + (String)variables[2]);
		
		variables = Sscanf.scan("My int: 12345, My long: -23432, My fixed int: -2344, My unsigned: -2344", 
				"My int: %i, My long: %d, My fixed int: %04i, My unsigned: -%u",(int) 1, 2, (int)3, 4);
		
		System.out.println("parse count: " + variables.length);
		System.out.println("int: " + (Integer)variables[0]);
		System.out.println("long: " + (Long)variables[1]);
		System.out.println("fixed int: " + (Integer)variables[2]);
		System.out.println("unsigned: " + (Long)variables[3]);
		
	}

}
