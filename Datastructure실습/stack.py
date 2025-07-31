#스택의 선언
class Stack:
    def __init__(self) :
        self.items=[] #데이터 저장을 위한 리스트
    def push(self,val):
        self.items.append(val)
    def pop(self):
        try:
            return self.items.pop()
        except IndexError:
            print("Stack is empty")
    def top(self):
        try:
            return self.items[-1] #맨 마지막 리스트 , 스택의 탑 리턴
        except IndexError:
            print("Stack is empty")
    def len(self):
        return len(self.items)
    def empty(self):
        return self.len()==0
	
class stack:
	def__init__(self,size):   #스폐셜 매서드
		self items=[]*size
    self idx=-1
	def push(self,val):
		if(self.idx+1==len(self)):
			print("stack is full")
		self.idx+=1
		self items[selp idx]=val
	def pop(self):
		if self idx==-1:
			print("stack is empty")
			return None