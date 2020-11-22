1.用 add first 或 add last 这套新的 API 改写 Deque 的代码
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
  
  
  2.分析 Queue 和 Priority Queue 的源码
  
  
Queue
        抛异常：add，remove，element
        返回null：offer，poll，peek
        
    队列	                有界性	            锁	       数据结构
    ArrayBlockingQueue    bounded                加锁        arraylist
		                	   
LinkedBlockingQueue	optionally-bounded	加锁	   linkedlist
ConcurrentLinkedQueue	unbounded	        无锁	   linkedlist
LinkedTransferQueue	unbounded		无锁         linkedlist
PriorityBlockingQueue	unbounded		加锁           heap
DelayQueue	        unbounded		加锁          heap
