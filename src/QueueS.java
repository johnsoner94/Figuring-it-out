/*
 *   class QueueS
 *   
 *   An implementation of the QueueInterface using stacks.
 *   
 *    Emily Johnson
 *    Ron Gerschel
 *    10/9/2014
 */

public class QueueS<T> implements QueueInterface<T>
{
	
	Stack<T> stk1 = new Stack<T>(); 
	Stack<T> stk2 = new Stack<T>();
	
	/*
	 *    The Queue constructor.
	 */
	
	public QueueS()
	{
		stk1 = new Stack<T>();
		stk2 = new Stack<T>();
	}

	/*
	 *    enqueue() - add an item to the rear of the queue.
	 *                Do nothing if the queue is full.
	 */
	
	public void enqueue(T item)
	{
		if(!isFull())
		{	
			if(!stk2.isEmpty())
	    	{
	    		while(!stk2.isEmpty())
	    			stk1.push(stk2.pop());	// Takes everything from stack 
	    									// 2 and puts it into stack 1
	    	}
			
			stk1.push(item);				// Adds item to stack 1
			
			if(!stk1.isEmpty())
			{
				while(!stk1.isEmpty())
					stk2.push(stk1.pop());	// Takes everything from stack 
											// 1 and puts it into stack 2
			}
		}
	}
	
    /*
     *   dequeue() - delete and return the front item
     *               in the queue. Return null if 
     *               the queue is empty.
     */
	
	public T dequeue()
	{
		if (isEmpty()) 
			return null;
		
		if (stk2.isEmpty())
		{
			while (!stk1.isEmpty())
				stk2.push(stk1.pop());	// Takes everything from stack 1 
										// and puts it into stack 2
		}
		
		return stk2.pop();		
	}
	
	/*
	 *    front() - Return (but do not delete) the item
	 *              at the front of the queue.
	 */
	
    public T front()
    {
    	return stk1.top();
    }
    
    /*
     *    isEmpty() - returns true if the queue is empty 
     *                else returns false.
     */
    
    public boolean isEmpty()
    {
    	if(stk1.isEmpty() && stk2.isEmpty())	// Checks both stacks
    		return true;
    	else
    		return false;
    }
    
    /*
     *    isFull() - returns true if the queue is empty 
     *               else returns false.
     */
    
    public boolean isFull()
    {
    	return stk1.isFull();
    }
    
    /*
     *  toString() - return a printable display of
     *               the items in the queue.
     */
    
    public String toString()
    {    	
    	String queueSString = "";
    	queueSString += stk2.toString();
    	return queueSString;
    }
}

