import com.sun.corba.se.impl.orbutil.graph.Node;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.NoSuchElementException;

public class Queue<Item>
{
    //队列的实现
    //设置基础属性
    private int n;
    private Node<Item> first;
    private Node<Item> last;
    public Queue()
    {
        //构造函数
        n=0;
        first=null;
        last=null;
    }
    public class Node<Item>
    {
        private Item item;
        private Node<Item> next; 
    }
    public boolean isEmpty(){return first==null;}
    public int size(){return n;}
    public void enqueue (Item item)
    {
        //装入值
        Node<Item> oldlast=last;
        last = new Node<Item>();
        last.item= item;
        last.next=null;
        //如果队列已空，则开头指向结尾
        if (isEmpty()){first=last;}
        else{oldlast.next=last;}
        n++;
    }
    public Item dequeue()
    {
        //从表头删除元素
        Item item =first.item;
        first=first.next;
        n--;
        if(isEmpty()){last=null;}
        return item;
    }
    public static void main(String[] args) {
        //创造一个队列的实例
        Queue<String> queue=new Queue<String>();
        while(!StdIn.isEmpty())
        {
            String item=StdIn.readString();
            if (!item.equals("-")){queue.enqueue(item);}
            else if (!queue.isEmpty())
            {
                StdOut.print(queue.dequeue()+" ");
            }
        }
        StdOut.println("("+queue.size()+" left on the queue"+")");

    }
}