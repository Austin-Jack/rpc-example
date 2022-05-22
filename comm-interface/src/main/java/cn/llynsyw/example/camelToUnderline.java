package cn.llynsyw.example;


/**
 * TODO
 *
 * @author luolinyuan
 * @date 2022/5/21
 **/
public class camelToUnderline {

	/*useHTTPServer - > use_http_sever*/
	public String transform(String camelCase) {
		StringBuilder result = new StringBuilder();
		char[] chars = camelCase.toCharArray();
		boolean isConstant = true;
		int length = chars.length;
		for (int i = 0; i < length; i++) {
			char ch = chars[i];
			char next = i + 1 < length ? chars[i + 1] : 0;
			/*如果连续 直接加到最后*/
			if (isConstant) {
				result.append(ch);
				isConstant = isConstant(ch, next);
				continue;
				/*当前为小写字母前一个为大写字母 那前一个大写字母应该和当前小写字母是一起的*/
			} else if (Character.isLowerCase(ch) && Character.isUpperCase(chars[i - 1])) {
				/*如果大写字母没有被_分割才需要插入_ 不然就不用了因为已经分过来了*/
				if (result.charAt(result.length() - 2) != '_') {
					result.insert(i, '_');
				}
			} else {
				result.append('_');
			}
			result.append(ch);
			isConstant = isConstant(ch, next);
		}
		return result.toString().toLowerCase();
	}

	public boolean isConstant(char prev, char next) {
		return (Character.isDigit(prev) && Character.isDigit(next)) ||
				(Character.isUpperCase(prev) && Character.isUpperCase(next)) ||
				(Character.isLowerCase(prev) && Character.isLowerCase(next));
	}

	public static void main(String[] args) {
		camelToUnderline o = new camelToUnderline();
		System.out.println(o.transform("useHTTPServer"));
		System.out.println(o.transform("useHTTPSServer"));
		System.out.println(o.transform("useHTTP2Server"));
	}

}
