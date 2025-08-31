import sys
input=sys.stdin.readline
#divide and conquer
def merge(arr,low,high):
  global cnt
  tmp=[]
  mid=(low+high)//2#여기서 () <-괄호 무조건 있어야 한다 연산자 우선순위!!
  i,j=low,mid+1#i,j는 붙이고자 하는 sub_list 2개의 각각 첫번째 원소이다
  while i<=mid and j<=high:#둘중 하나가 sub_list의 끝인덱스에 다다른다면 나머지하나는 그냥 tmp에 붙여주면 된다 
    if arr[i]<=arr[j]:#i가 왼쪽,j가 오른쪽
      tmp.append(arr[i])
      i+=1
    else:# arr[i]>arr[j] 오른쪽이 더 작은경우 swap해주어야하므로
      cnt+=mid-i+1
      tmp.append(arr[j])
      j+=1
  while i<=mid:
    tmp.append(arr[i])
    i+=1
  while j<=high:
    tmp.append(arr[j])
    j+=1
  for k in range(low,high+1):
    arr[k]=tmp[k-low]
  return arr

def merge_sort(arr,low,high):
  if low>=high :
    return 
  mid=(low+high)//2
  merge_sort(arr,low,mid)#왼쪽반 divide
  merge_sort(arr,mid+1,high)#오른쪽반 divide
  sorted_list=merge(arr,low,high)# 2개의 sub_list를 병합하여 하나의 리스트로 만들기
  return sorted_list

n=int(input())#수열의 크기
arr=list(map(int,input().split()))
cnt=0
merge_sort(arr,0,n-1)
print(cnt)