import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int [] arr =new int[N];
        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int evenNum=0;
        int oddNum=0;
        int en =0;
        int maxLen=0;
        for(int st=0;st<N;st++){
            while(en<N && oddNum<=K){
                if(arr[en]%2==0){
                    evenNum++;
                }
                else{
                    oddNum++;
                }
                en++;
            }
            maxLen=Math.max(maxLen,evenNum);
            if(arr[st]%2==0){evenNum-=1;}
            else {oddNum-=1;}//st 가 증가하기 전에 st (짝수인지, 홀수인지에따라) evenNum,oddNum 갱신하기
        }
        System.out.println(maxLen);
    }
}