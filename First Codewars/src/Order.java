import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;







public class Order {

  public static String order(String words) {

	  List<String> list = new ArrayList<>();
	  splitStringtoListWords(words, list);
	  String sortedWords = sortListWordsbyNumbers(list);
	  System.out.println(sortedWords);
	return sortedWords;

    
  }


private static String sortListWordsbyNumbers(List<String> list) {
	Pattern p1 = Pattern.compile("\\d");
	  Comparator<String> comp = (s1,s2) -> 
	  			{
	  				Matcher m2Matcher = p1.matcher(s1);
	  				Matcher m3Matcher = p1.matcher(s2);
	  				while(m2Matcher.find()&& m3Matcher.find())
	  					return Integer.compare(Integer.parseInt(m2Matcher.group()),Integer.parseInt(m3Matcher.group()));
					return 0 ;
	  			};
	  
	  List<String> sortedList = list.stream()
		        .sorted(comp)
		        .collect(Collectors.toList());
	  
	  
	  String listString = sortedList.stream().map(Object::toString)
              .collect(Collectors.joining(" "));
	return listString.trim();
}


private static void splitStringtoListWords(String words, List<String> list) {
	Pattern p = Pattern.compile("\\s*\\w*\\d+\\w*\\s*");

	  Matcher m = p.matcher(words);

	  while (m.find()) {

	    list.add(m.group().trim());
	    System.out.print(m.group());
	
		}
}
}