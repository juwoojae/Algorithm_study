import sys
input=sys.stdin.readline
n=int(input())
a=[list(input().rstrip()) for _ in range(n)]
ans=sys.maxsize#무한대
def swap_row(i):#i행을 모두 뒤집기
  for k in range(n):
    if a[i-1][k]=='H':
      a[i-1][k]='T'
    elif a[i-1][k]=='T':
      a[i-1][k]='H'
      
def optimizing_col():#열 최적화
  tot_T=0
  for i in range(n):
    tmp=0
    for j in range(n):
      if a[j][i]=='T':#열 i에서 T가 나오면
        tmp+=1
    if n-tmp<tmp:#뒤집기한 T횟수 현재T횟수
      tmp=n-tmp
    tot_T+=tmp
  return tot_T
def go(i):
  global ans
  if i == n:
    if ans>optimizing_col():
      ans=optimizing_col()
    return
  go(i+1)
  swap_row(i)#i행을 뒤집기 
  go(i+1)

go(0)
print(ans)