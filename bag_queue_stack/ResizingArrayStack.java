import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class ResizingArrayStack<Item> implements Iterable<Item>
{
    //栈类的数组实现
    //设置元素属性
    private Item[] a;
    //设置最大存量属性
    private int N;
    public ResizingArrayStack() {
        //构造函数
        a = (Item[]) new Object[2];
        N = 0;
    }
    //检查是否为空
    public boolean isEmpty(){return N==0;}
    //返回现在的元素数量
    public int size(){return N;}
    private void resize(int max)
    {   //调整栈的大小
        Item[] temp=(Item[]) new Object[max];
        for (int i=0;i<N;i++)
        {
            temp[i]=a[i];
        }
        a=temp;
    }
    public void push(Item item)
    {
        //压入元素
        a[N++]=item;
        //如果满了改变栈的大小
        if (a.length==N)
        {
            resize(2*a.length);
        }
    }
    public Item pop()
    {
        //取出元素
        Item item=a[--N];
        a[N]=null;
        //如果栈空了改变大小
        if(N>0&&N==a.length/4)
        {
            resize(a.length/2);
        }
        return item;
    }
    public Iterator<Item> iterator()
    {
        //返回一个迭代器
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item>
    { 
        //支持后进先出的迭代
        //设置当前元素所在的位置
        private int i=N;
        public boolean hasNext()
        {
            return i==0;
        }
        public Item next()
        {
            return a[--i];
        }
        public void remove()
        {

        }
    }
    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
        while (!StdIn.isEmpty()) {
            //System.out.println("#");
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}