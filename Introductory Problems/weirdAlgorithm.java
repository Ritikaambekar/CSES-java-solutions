


import java.util.*;

public class weirdAlgorithm {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long n = s.nextLong();
        System.out.print(n+" ");
		while(n > 1) {
			if(n%2 == 0) {
				n = n / 2;
				System.out.print(n+" ");
			}else if(n%2 == 1){
				n =3*n + 1;
				System.out.print(n+" ");
			}
		}

	}

}
