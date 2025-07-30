import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] arr=new int[N];
        for(int i=0;i<N;i++){ arr[i]=Integer.parseInt(br.readLine());}
        //입력
        Arrays.sort(arr);
        int ans=2100000000;
        int en=0;
        int start=0;
        while(en!=N && start!=N){
            if(arr[en]-arr[start]>=M){
                ans=Math.min(arr[en]-arr[start],ans);
                start+=1;
            }
            else{
            en+=1;}
        }
        System.out.println(ans);
    }
}