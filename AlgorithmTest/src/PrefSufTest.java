import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 * @author Ahmed
 * 
 */
public class PrefSufTest {

	// Test:: [4, 4, 7, 4, 1, 3, 5, 7, 6, 1, 2, 4]
	public static void main(String[] args) {
		int A[] = { 3, 5, 7, 3, 3, 5 };
		System.out.print(solution(A));

	}

	// you can also use imports, for example:
	// import java.math.*;

	public static int solution(int A[]) {

		long ctr = 0;

		ArrayList pa = new ArrayList();
		ArrayList sa = new ArrayList();

		for (int i = 0; i < A.length; i++) {

			for (int x = 0; x <= i; x++) {
				pa.add(A[x]);
			}

			for (int j = A.length - 1; j >= 0; j--) {

				for (int y = j; y <= A.length - 1; y++) {
					sa.add(A[y]);
				}

				sa = rearrange(sa);
				pa = rearrange(pa);

				if (sa.equals(pa)) {
					System.out.println("here's pair" + "[" + i + "]" + "[" + j
							+ "]");
			//		 System.out.println(pa + " " + sa);
					ctr++;
				}

			}
			sa.clear();
			pa.clear();
		}
		if(ctr > 1000000000) return 1000000000;
		
		else {return (int)ctr;}
	}

	public static ArrayList rearrange(ArrayList al) {
		HashSet hs = new HashSet();
		hs.addAll(al);
		al.clear();
		al.addAll(hs);
		return al;
	}

}
