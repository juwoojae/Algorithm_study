import sys
n,m,k=map(int,sys.stdin.readline().split())
if m+k-1<=n<=m*k:
  seq=[i+1 for i in range(n)]
  group=[]
  group.append((0,k-1))
  n-=k
  m-=1
  div=k
  while m>0:
    tmp_n,tmp_m=n-div,m-1
    if tmp_n>=tmp_m:
      n-=div
      m-=1
      group.append((group[-1][1]+1,group[-1][1]+div))
    else:
      div-=1
  ans=[]
  for u,v in group:
    ans+=seq[u:v+1][::-1]
  print(" ".join(map(str,ans)))
else:
  print(-1)