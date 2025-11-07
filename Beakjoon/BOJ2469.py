k=int(input())
n=int(input())
end=list(input())
hiderow=0#숨겨진열
a=[]
order=[]
for idx in range(n):
  row=input()
  if row[0]=='?':
    hiderow=idx
  a.append(row)
for i in range(k):
  order.append(chr(i+65))
for i in range(hiderow):
  for j in range(k-1):
    if a[i][j]=='-':
      order[j],order[j+1]=order[j+1],order[j]
for i in range(n-1,hiderow,-1):
  for j in range(k-1):
    if a[i][j]=='-':
      end[j],end[j+1]=end[j+1],end[j]
ans=""
for i in range(k):
  for j in range(k):
    if order[i]==end[j]:
      if abs(i-j)>=2:#거리의 차이가 2이상나면 사다리로는 도달할수 없다
        ans="x"*(k-1)
if not ans:# 조건에 걸리지 않는다면 사다리를 탈수있다
  for i in range(k-1):
    if order[i]==end[i]:
      ans+='*'
    else:#다르다면 바꾸기 1차이므로 다음거랑 바꾸기
      order[i],order[i+1]=order[i+1],order[i]
      ans+='-'
print(ans)
