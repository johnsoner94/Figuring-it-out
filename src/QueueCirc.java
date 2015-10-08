/*
 *   class QueueCirc
 *   
 *   A Circular Implementation of the generic QueueInterface.
 *   
 *    Emily Johnson
 *    Ron Gerschel
 *    10/9/2014
 */

public class QueueCirc<T> implements QueueInterface<T>
{
	public int front = 0;   // Index of the front item in the queue.
	public int rear = -1;   // Index of the rear item in the queue.

	public T[] A = (T[]) new Object[20];  // Generic arrays cannot be 
										  // constructed in Java.
	// A solution is to create an array of Object
	// and type cast as an array of a generic type.
	// Ignore any warnings the compiler generates.
	/*
	 *    The Queue constructor.
	 */

	public QueueCirc()
	{
		
	}
	/*
	 *    enqueue() - add an item to the rear of the queue.
	 *                Do nothing if the queue is full.
	 */

	public void enqueue(T item)
	{
		if(!isFull()) 
		{
			// If the rear reaches the end of the array rear is reset to -1
			if (rear == A.length-1)
			{
				rear = -1;
			}

			//  Add 1 to rear and then set rear equal to item
			rear = (rear+1);
			A[rear] = item;
		}
	}


	/*
	 *   dequeue() - delete and return the front item
	 *               in the queue. Return null if 
	 *               the queue is empty.
	 */

	public T dequeue()
	{
		T item = null;

		if (isEmpty())
			return item;

		else 
		{
			if (front == A.length-1)	// Moves the front to the beginning 
										// of the circ queue if you reach 
										// the end of the array.
				front = 0;				
			item = A[front];			
			A[front] = null;		// Sets front value equal to null
			front = (front + 1);	// Moves front to the next spot in array
		}
		return item;
	}


	/*
	 *    front() - Return (but do not delete) the item
	 *              at the front of the queue.
	 */

	public T front()
	{
		return A[front]; // returns the value of front of circ queue
	}

	/*
	 *    isEmpty() - returns true if the queue is empty 
	 *                else returns false.
	 */

	public boolean isEmpty()
	{
		if (rear == front-1)
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
		int difference = front - rear;
		if (difference == 2 || difference == (A.length-2))	// If the 
															// difference
															// equals 2 or
															// the length 
															// of the array
															// minus 2 
															// returns true
			return true;
		return false;
	}

	/*
	 *  toString() - return a printable display of
	 *               the items in the queue.
	 */

	public String toString()
	{
		String circQueueString = " ";
		int i = front;

		while(i!=rear+1)
		{	
			if(i == A.length-1)	// If i reaches the end of the array, but 
								// not the end of the queue before reaching
								// rear then i resets to beginning of array
				i=0;

			else if(i == rear)	// Used to format a clear list of the 
								// objects in the array.
			{
				circQueueString += A[i];
				i++;
			}
			else
			{
				circQueueString += A[i] + ", ";	// Used to format a clear 
												// list of the objects in
												// the array.
				i++;
			}

		}
		return circQueueString;
	}
}


