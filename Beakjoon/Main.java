//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int col;
    static int row;
    static char[][] table;
    static int[][] dist; //방문안된건 -1 /된거는 0이상 최단거리 누적
    public static void distRenew(){
        dist=new int[col][row];  //다시 초기화
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                dist[i][j]=-1;
            }
        }
    }
    public static int bfs(int x,int y){   //시작좌표를 입력받아 너비탐색한후 시작지점으로부터 가장많이간 최단거리 리턴
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[] {x,y});
        dist[x][y]=0;  //방문 표시
        int ans=0;
        int[] dx={1,-1,0,0};int[] dy={0,0,-1,1};
        while(!q.isEmpty()){
            int[] tmp=q.poll();
            for(int i=0;i<4;i++){
                int nx=tmp[0]+dx[i];
                int ny=tmp[1]+dy[i];
                if(0<=nx && nx<col && 0<=ny && ny<row){
                    if(table[nx][ny]=='L' && dist[nx][ny]==-1){
                        dist[nx][ny]=dist[tmp[0]][tmp[1]]+1;
                        ans=Math.max(dist[nx][ny],ans);
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tmp= new StringTokenizer(br.readLine()," ");
        col=Integer.parseInt(tmp.nextToken());
        row=Integer.parseInt(tmp.nextToken());
        table=new char[col][row];
        int ans=0;
        for(int i=0;i<col;i++){
            table[i]= br.readLine().toCharArray();
        }
        //----------------------입력부---------------------
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                if(table[i][j]=='L'){
                    distRenew();
                    ans=Math.max(ans,bfs(i,j));
                }
            }
        }
        System.out.println(ans);
    }
}
