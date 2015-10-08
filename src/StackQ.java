
/*
 *    An implementation of the StackInterface using Queues.
 *    
 *    Emily Johnson
 *    Ron Gerschel
 *    10/9/2014
 */

public class StackQ <T> implements StackInterface<T> {

	QueueCirc<T> qc = new QueueCirc<T>();		// Implements QueueCir
	QueueCirc<T> qc2 = new QueueCirc<T>();
	
	/*
	 *   push(item) - add item to the stack.  It is at
	 *                the front of the list.
	 */
	
	public void push(T item)
	{
        qc.enqueue(item);
	}                                    
	
	
	/*
	 *   pop() - remove the top item from the stack and
	 *           return it as the function value.
	 */
	
	public T pop()
	{
//		if (qc2.isEmpty())
//		{
//			while (!qc.isEmpty())
//				qc2.push(qc.top());	// Takes everything from stack 1 
//										// and puts it into stack 2
//		}
		return qc.dequeue();
	}
	
	/*
	 *   top() - return the top stack item.
	 */
	
	public T top()
	{
		return qc.front();
	}
	
	/*
	 *    isEmpty() - return True if the stack is empty
	 *                otherwise return False.
	 */
	
	public boolean isEmpty()
	{
		return qc.isEmpty();
	}
	
	
	/*
	 *    isFull() - return True if the stack is full
	 *                otherwise return False.
	 */
	
	public boolean isFull()
	{
		return qc.isFull();
	}
	
}
