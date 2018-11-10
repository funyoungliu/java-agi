import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;

import com.sun.corba.se.impl.orbutil.graph.Node;
public class Stack<Item>
{
    //声明变量
    private Node<Item> first;
    private int N;
    private static class Node<Item>
    {
        Item item;
        Node next;
    }
    //构造函数
    public Stack()
    {
        first=null;
        N=0;
    }
    //检查是否为空
    public boolean isEmpty(){return N==0;}
    //返回栈的大小
    public int size()
    {
        return N;
    }
    //压入栈
    public void push(Item item)
    {
         Node<Item> oldfirst=first;
         first = new Node<Item>();
         first.item=item;
         first.next=oldfirst;
         N++;
    }
    //弹出栈顶元素
    public Item pop()
    {
        Item item=first.item;
        first=first.next;
        N--;
        return item;}
    //测试用例
    public static void main(String[] args)
    {
        Stack<String> stack=new Stack<String>();
        while(!StdIn.isEmpty())
        {
           String item= StdIn.readString();
           if(!item.equals("-"))
           {
               stack.push(item);
           }
           else if (!stack.isEmpty())
           {
               StdOut.print(stack.pop()+" ");
           }
        }
        StdOut.println("("+stack.size()+" left on stack)");
    }

}