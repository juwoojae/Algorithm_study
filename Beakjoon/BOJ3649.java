import java.io.*;
import java.util.*;

public class Main {
    static int x;
    static int n;
    static int[] arr;

    public static String ans() {
        if (n < 2) {
            return "danger";
        }
        int en = n - 1;
        int st = 0;
        while (st < en) {
            if (arr[st] + arr[en] < x) {
                st += 1;
            } else if (arr[st] + arr[en] > x) {
                en -= 1;
            } else {  //arr[st] + arr[en] == x 문제에서 원하는 상황이므로
                return "yes " + arr[st] + " " + arr[en];
            }
        }
        return "danger";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = null;
        while ((tmp = br.readLine()) != null) {
            x = Integer.parseInt(tmp) * 10000000;
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }//입력
            Arrays.sort(arr);
            System.out.println(ans());
        }
    }
}