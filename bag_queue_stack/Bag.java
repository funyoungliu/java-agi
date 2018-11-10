import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

import com.sun.corba.se.impl.orbutil.graph.Node;

public class Bag<Item> implements Iterable<Item>
{
    //bag实现类
    //设置属性
    private Node<Item> first;
    //Node 内部类
    public class Node<Item>
    {
        private Item item;
        private Node<Item> next;
    }
    public Bag()
    {
        first=null;
    }
    public boolean isEmpty(){return first==null;}
    public void add(Item item)
    {
        //添加元素
        Node<Item> oldfirst =first;
        first=new Node<Item>();
        first.item=item;
        first.next=oldfirst;
    }
    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }
    public class ListIterator implements Iterator<Item>
    {
        private Node<Item> current =first;
        public boolean hasNext()
        {
            return current!=null;
        }
        public void remove(){}
        public Item next()
        {
            Item item =current.item;
            current=current.next;
            return item;
        }
    }
}