import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T>{
    class Node{
        private T data;
        private Node next;
        private Node prev;
        Node(T val){
            data=val;
            next=null;
            prev=null;
        }
        }
    private Node head;
    private Node tail;
    DoublyLinkedList(){
            head=null;
            tail=null;
        }

    public void insertAtBeginning(T val){
        Node newNode=new Node(val);
        if (head==null){
            head=newNode;
            tail=newNode;
        }
        else{
            head.prev=newNode;
            newNode.next=head;
            head=newNode;
            
        }

    }

    public void traversal(){
        Node temp=head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp=temp.next;      
          }
        
    }

    public void traversalRev(){
        Node temp=tail;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp=temp.prev;      
          }
        
    }

    public void insertAtPos(int pos,T val){
        if (pos == 0){
            insertAtBeginning(val);
            return;
        }
        Node newNode = new Node(val);
        Node temp = head;
        
        for(int i=1;i<pos;i++){
            temp=temp.next;
            if (temp==null){
                throw new IndexOutOfBoundsException("Invalid position: "+pos);
            }
        }
        newNode.next=temp.next;
        newNode.prev=temp;
        if(head==tail)
            tail=newNode;
        else    
            temp.next.prev=newNode;
        temp.next=newNode;
    }

    public void deleteAtPos(int pos){
        if (head==null){
            throw new IndexOutOfBoundsException("Delection attemped on empty list:"+pos);
        }
        if (pos==0){
            head=head.next;
            if (head==null)
                tail=null;
            else    
                head.prev=null;
            return;
        }
        Node temp=head;
        Node prev=null;
        for(int i=1;i<=pos;i++){
            prev=temp;
            temp=temp.next;
            if(temp==null)
                throw new IndexOutOfBoundsException("Invalid Position");
        }
        prev.next=temp.next;
        if(temp.next==null)
            tail=prev;
        else    
            temp.next.prev=prev;
    }

    public void deleteAtBeginning(){
        if(head==null)
           throw new IndexOutOfBoundsException("Delection attemped on empty list"); 
        head=head.next;
        if (head==null)
            tail=null;
        else    
            head.prev=null;

    }


    public void get(int pos){
        Node temp=head;

        for (int i=1;i<=pos;i++){
            temp=temp.next;
            if (temp==null){
            throw new IndexOutOfBoundsException("list:"+pos);
        }
        }
        System.out.println(temp.data);
    }

    public void update(int pos,T val){
        Node temp = head;

        for (int i=1;i<=pos;i++){
            temp=temp.next;
            if (temp==null){
            throw new IndexOutOfBoundsException("list:"+pos);
        }
        }
        temp.data=val;
    }

    public void deleteAtEnd(){
        Node temp=head;
        Node prv=null;
        while(temp.next!=null){
            prv=temp;
            temp=temp.next;
        }
        tail=prv;
        prv.next=null; 
        //tail=prv;
    }

    public void insertAtEnd(T val){
        Node newNode = new Node(val);
        Node prv=null;
        Node temp=head;
        if (temp==null){
            head=newNode;
            tail=newNode;
        } 
        else
            while(temp!=null){
                prv=temp;
                temp=temp.next;
            }
            prv.next=newNode;
            newNode.prev=prv;
            tail=newNode;
    }

    public void search(T val){
        Node temp=head;
        int pos=0;
        while(temp != null){
            if (temp.data == val){
            System.out.println(pos);
        }
            temp=temp.next; 
            pos++;     
          }
    }

    public boolean contains (T val){
        Node temp=head;
        boolean flag=false;
        while(temp != null){
            if (temp.data == val){
            flag=true;
        }
            temp=temp.next;      
          }
          return flag;
    }

    public void length (){
        Node temp = head;
        int len = 0;
        
        while(temp != null){
            temp=temp.next;
            len ++;
        }
        System.out.println(len);
    }


    public Iterator<T> iterator(){
        return new Iterator<T>() {
        Node temp = head;
        public boolean hasNext(){
            return temp !=null;

         }

        public T next(){
            T val = temp.data;
            temp=temp.next;
            return val;
         }

        };
    }
    public Iterator<T> iteratorRev(){
        return new Iterator<T>(){
            Node temp=tail;
            public boolean hasNext(){
                return temp != null;
            }
            public T next(){
                T val=temp.data;
                temp=temp.prev;
                return val;
            }
        };
    }

}


