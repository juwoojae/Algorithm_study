class Node:
    def __init__(self, key=None):
        self.key = key
        self.next = None
    def __str__(self):
        return str(self.key)
	
class SinglyLinkedList:
    def __init__(self):
        self.head = None
        self.size = 0
	
    def __len__(self):
        return self.size
	
    def printList(self): # 변경없이 사용할 것!
        v = self.head
        while(v):
            print(v.key, "->", end=" ")
            v = v.next
        print("None")
	
    def pushFront(self, key):
        new_node=Node(key)
        new_node.next=self.head
        self.head=new_node
        self.size+=1

    def pushBack(self, key):
        new_node=Node(key)
        if(self.size==0):
            self.head=new_node
        else:
            tail=self.head
            while(tail.next!=None):
                tail=tail.next
            tail.next=new_node
        self.size+=1
    def popFront(self): 
        if self.head==None:
            return None
        else:
            x=self.head
            key=x.key
            self.head=x.next
            del x
            self.size-=1
            return key

    def popBack(self):# tail 노드의 값 리턴. empty list이면 None 리턴
        if self.size==0: #케이스 3가지 1.아예 비여있는경우 2.1개만 있는경우(self.head=None 만들어주기!) 3.2개이상 있는경우 prev,tail노드이용!
            return None
        prev,tail=None,self.head
        while tail.next!=None:
            prev=tail
            tail=tail.next
        if(prev==None): # 1개의 노드인경우
            self.head=None
        else: #노드가 2개 이상인 경우
            prev.next=tail.next
        key=tail.key
        self.size-=1
        return key
        
    	# key 값을 저장된 노드 리턴. 없으면 None 리턴
    def search(self, key_):
        v=self.head
        while(v!=None):
            if v.key==key_:
                return v
            v=v.next
        return None # key 값 발견 안됨
			
        # 노드 x를 제거한 후 True리턴. 제거 실패면 False 리턴
    def remove(self, x):
        if self.size == 0 or x == None: # 경우 (1)
            return False
        elif x==self.head:
            self.popFront()
            return True
        else:
            v =self.head
            while v.next !=x:
                v=v.next
            v.next =x.next
            self.size-=1
            return True