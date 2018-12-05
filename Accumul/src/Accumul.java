import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Accumul {
	

	public static String accum(String s) {

		AtomicInteger atomicInteger = new AtomicInteger(-1);
		return Stream
				.of(s.split("\\s*"))
				.map(str -> {
					return str.toUpperCase().concat(
							(String) String.join("", Collections.nCopies(
									atomicInteger.incrementAndGet(), str.toLowerCase())));
				}).collect(Collectors.joining("-"));
	}
}