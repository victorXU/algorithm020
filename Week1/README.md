#1.用 add first 或 add last 这套新的 API 改写 Deque 的代码
     
    Deque<String> deque = new LinkedList<>();
         deque.addFirst("a");
         deque.addFirst("b");
         deque.addFirst("c");
         System.out.println(deque);
         String str = deque.peekFirst();
         System.out.println(str);
         System.out.println(deque);
         while (deque.size()>0){
             System.out.println(deque.removeFirst());
         }
         System.out.println(deque);
   
  
  
#  2.分析 Queue 和 Priority Queue 的源码
  
  
##Queue
        抛异常：add，remove，element
        返回null：offer，poll，peek
        
    队列	                有界性	            锁	       数据结构
    ArrayBlockingQueue    bounded                加锁        arraylist
    LinkedBlockingQueue   optionally-bounded     加锁        linkedlist
    ConcurrentLinkedQueue unbounded              无锁        linkedlist
    LinkedTransferQueue    unbounded		无锁         linkedlist
    PriorityBlockingQueue  unbounded		加锁           heap
    delayQueue	        unbounded		加锁          heap
    
    参考文档：[高性能队列——Disruptor](https://tech.meituan.com/2016/11/18/disruptor.html)
## PriorityBlockingQueue


        /**
         * 初始化大小
         */
        private static final int DEFAULT_INITIAL_CAPACITY = 11;
    
        /**
         * 无界队列，
         * OutOfMemoryError: Requested array size exceeds VM limit
         */
        private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    
        /**
         *最小二叉堆
         */
        private transient Object[] queue;
    
        /**
         * The number of elements in the priority queue.
         */
        private transient int size;
    
        /**
         * 比较器
         */
        private transient Comparator<? super E> comparator;
    
        /**
         * Lock used for all public operations
         */
        private final ReentrantLock lock;
    
        /**
         * Condition for blocking when empty
         */
        private final Condition notEmpty;
    
        /**
         * CAS+自旋锁
         */
        private transient volatile int allocationSpinLock;    

    都需要加锁
    add==offer==put
    poll==take==dequeue
     peek
     remove  
