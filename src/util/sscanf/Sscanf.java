package util.sscanf;

import java.util.ArrayList;
import java.util.List;



public class Sscanf {

	public static Object[] scan(String source, String format, Object... params) {
		List<Object>outs = new ArrayList<Object>();
		SscanfFormat sf = new SscanfFormat(source, format);
		
		for(Object param : params) {
			Object o = parse(sf, param);
			if(o == null)
				break;
			else
				outs.add(o);
		}
		return outs.toArray();
	}
	
	
	private static Object parse(SscanfFormat sf, Object param) {
		if(!sf.prepareNextParseParam()) {
			return null;
		}
		Object o = null;
		
		if (param instanceof Number) {
			if (param instanceof Integer) {
				o = sf.parse((Integer) param);
			} else if (param instanceof Long) {
				o = sf.parse((Long) param);
			} else if (param instanceof Double) {
				//o = sf.parse((Double) param);
			} else if (param instanceof Float) {
				//o = sf.parse((Float) param);
			} else {
				//o = sf.parse((Number)param);
			}
		} else if (param instanceof Character) {
			o = sf.parse((Character) param);
		} else {
			o = sf.parse(param.toString());
		}
		
		return o;
	}
}
